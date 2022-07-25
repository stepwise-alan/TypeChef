// https://github.com/harrah/xsbt/wiki/Full-Configuration-Example

import sbt.Keys._

import java.text.SimpleDateFormat
import java.util.Date
import scala.sys.process._


val junit = "junit" % "junit" % "latest.integration" % "test"
val junitInterface = "com.novocode" % "junit-interface" % "latest.integration" % "test"
val scalacheck = "org.scalacheck" %% "scalacheck" % "latest.integration" % "test"
val scalatest = "org.scalatest" %% "scalatest" % "latest.integration" % "test"
val scalatestplus = "org.scalatestplus" %% "junit-4-13" % "latest.integration" % "test"
val scalaparsercombinators = "org.scala-lang.modules" %% "scala-parser-combinators" % "2.1.1"
val scalaxml = "org.scala-lang.modules" %% "scala-xml" % "2.1.0"

val testEnvironment = Seq(junit, junitInterface, scalatest, scalatestplus, scalacheck)
val scala211Libraries = Seq(scalaparsercombinators, scalaxml)


val buildOrganization = "de.fosd.typechef"
val buildVersion = "0.4.2"
val buildScalaVersion = "2.13.8"


val current = """\*\s+(\w+)""".r

def gitBranches = ("git branch --no-color" lineStream_! new ProcessLogger {
  override def out(s: => String): Unit = {}

  override def err(s: => String): Unit = {}

  override def buffer[T](f: => T): T = f
}).mkString

val buildShellPrompt = {
  (state: State) => {
    val currBranch =
      current findFirstMatchIn gitBranches map (_ group 1) getOrElse "-"
    val currProject = Project.extract(state).currentProject.id
    "%s:%s:%s> ".format(
      currProject, currBranch, buildVersion
    )
  }
}


val buildSettings = Defaults.coreDefaultSettings ++ Seq(
  organization := buildOrganization,
  version := buildVersion,
  scalaVersion := buildScalaVersion,
  shellPrompt := buildShellPrompt,

  javacOptions ++= Seq("-Xlint:unchecked"),
  scalacOptions ++= Seq("-deprecation", "-unchecked"),
  testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v"),

  // suppress feature warnings in Scala 2.10.x
  // (we do not actually change the code to allow cross builds with prior scala versions)
  scalacOptions ++= {
    scalaVersion map {
      sv =>
        if (sv startsWith "2.1") List(
          "-feature",
          "-language:postfixOps",
          "-language:implicitConversions",
          "-Xfatal-warnings" // make sure we take warnings seriously
        )
        else Nil
    }
  }.value,

  crossScalaVersions := Seq("2.10.6", "2.11.8"),

  conflictWarning := ConflictWarning.disable,

  libraryDependencies := {
    CrossVersion.partialVersion(scalaVersion.value) match {
      // if scala 2.11+ is used, add dependency on scala-xml module
      case Some((2, scalaMajor)) if scalaMajor >= 11 =>
        libraryDependencies.value ++ testEnvironment ++ scala211Libraries
      case _ => libraryDependencies.value ++ testEnvironment
    }
  },

  // need to sequentially execute tests, because some tests may use BDDs
  // and others may use SAT and they should not intermix through parallelism
  Global / concurrentRestrictions += Tags.limit(Tags.Test, 1),

  homepage := Some(url("https://github.com/ckaestne/TypeChef")),
  licenses := Seq("GNU Lesser General Public License v3.0" -> url("https://www.gnu.org/licenses/lgpl.txt")),

  //maven
  publishTo := {
    version {
      (v: String) =>
        val nexus = "https://oss.sonatype.org/"
        if (v.trim.endsWith("SNAPSHOT"))
          Some("snapshots" at nexus + "content/repositories/snapshots")
        else
          Some("releases" at nexus + "service/local/staging/deploy/maven2")
    }
  }.value,
  publishMavenStyle := true,
  Test / publishArtifact := false,
  pomIncludeRepository := {
    _ => false
  },
  pomExtra :=
    <parent>
      <groupId>org.sonatype.oss</groupId>
      <artifactId>oss-parent</artifactId>
      <version>7</version>
    </parent> ++
      <scm>
        <connection>scm:git:git@github.com:ckaestne/TypeChef.git</connection>
        <url>git@github.com:ckaestne/TypeChef.git</url>
      </scm> ++
      <developers>
        <developer>
          <id>ckaestne</id> <name>Christian Kaestner</name> <url>http://www.cs.cmu.edu/~ckaestne/</url>
        </developer>
      </developers>,

  credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
)


val versionGen = TaskKey[Seq[File]]("version-gen")
val versionGenPackage = SettingKey[String]("version-gen-package")
val versionGenClass = SettingKey[String]("version-gen-class")


lazy val typechef = (project in file("."))
  .aggregate(
    featureexpr,
    conditionallib,
    parserexp,
    jcpp,
    cparser,
    errorlib,
    ctypechecker,
    javaparser,
    crewrite,
    frontend
  )
  .settings(
    buildSettings,
    name := "TypeChef"
  )

lazy val featureexpr = (project in file("FeatureExprLib"))
  .settings(
    buildSettings,
    name := "FeatureExprLib"
  )

lazy val conditionallib = (project in file("ConditionalLib"))
  .settings(
    buildSettings,
    name := "ConditionalLib"
  )
  .dependsOn(featureexpr)

lazy val errorlib = (project in file("ErrorLib"))
  .settings(
    buildSettings,
    name := "ErrorLib"
  )
  .dependsOn(featureexpr)

lazy val parserexp = (project in file("ParserFramework"))
  .settings(
    buildSettings,
    name := "ParserFramework"
  )
  .dependsOn(featureexpr, conditionallib, errorlib)

lazy val jcpp = (project in file("PartialPreprocessor"))
  .settings(
    buildSettings,
    name := "PartialPreprocessor"
  )
  .dependsOn(featureexpr, conditionallib, errorlib)

lazy val cparser = (project in file("CParser"))
  .settings(
    buildSettings,
    name := "CParser",
    libraryDependencies += scalaVersion(kiamaDependency(_)).value
  )
  .dependsOn(featureexpr, jcpp, parserexp, conditionallib, errorlib)

lazy val frontend = (project in file("Frontend"))
  .settings(
    buildSettings,
    name := "Frontend",
    versionGenPackage := {
      Keys.organization {
        org => org
      }
    }.value,
    versionGenClass := "Version",
    versionGen := {
      Def task {
        val sm = (Compile / sourceManaged).value
        val n = name.value
        val v = version.value
        val vgp = versionGenPackage.value
        val vgc = versionGenClass.value
        val file = sm / vgp.replace(".", "/") / ("%s.scala" format vgc)
        val code =
          (
            if (vgp != null && vgp.nonEmpty) "package " + vgp + "\n"
            else ""
            ) +
            "class " + vgc + " extends VersionInfo {\n" +
            "  def getVersion:String = \"" + v + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "\"\n" +
            "}\n"
        IO write(file, code)
        Seq(file)
      }
    }.value,
    Compile / sourceGenerators += versionGen map identity
  )
  .dependsOn(featureexpr, jcpp, cparser % "test->test;compile->compile", ctypechecker, conditionallib, crewrite, javaparser, errorlib)

lazy val ctypechecker = (project in file("CTypeChecker"))
  .settings(
    buildSettings,
    name := "CTypeChecker",
    libraryDependencies += scalaVersion(kiamaDependency(_)).value
  )
  .dependsOn(cparser % "test->test;compile->compile", conditionallib, errorlib)

lazy val javaparser = (project in file("JavaParser"))
  .settings(
    buildSettings,
    name := "JavaParser"
  )
  .dependsOn(featureexpr, parserexp, conditionallib, errorlib)

lazy val crewrite = (project in file("CRewrite"))
  .settings(
    buildSettings,
    name := "CRewrite",
    libraryDependencies += scalaVersion(kiamaDependency(_)).value
  )
  .dependsOn(cparser % "test->test;compile->compile", ctypechecker, conditionallib, errorlib)


def kiamaDependency(scalaVersion: String, testOnly: Boolean = false) = {
  val x = "org.bitbucket.inkytonik.kiama" %% "kiama" % "2.5.0"
  if (testOnly) x % "test" else x
}

