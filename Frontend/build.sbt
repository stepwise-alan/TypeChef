import sbtassembly.AssemblyPlugin.autoImport._

libraryDependencies += "gnu.getopt" % "java-getopt" % "latest.integration"

Runtime / mainClass := Some("de.fosd.typechef.Frontend")


//generate typechef.sh file with full classpath
TaskKey[File]("mkrun") := {
  Def task {
    val base = baseDirectory.value
    val cp = (Runtime / fullClasspath).value
    val main = (Runtime / mainClass).value
    val template =
      """#!/bin/sh
java -ea -Xmx1536m -Xms128m -Xss10m -classpath "%s" %s "$@"
"""
    val mainStr = main getOrElse sys.error("No main class specified")
    val contents = template.format(cp.files.absString, mainStr)
    val out = base / "../typechef.sh"
    IO.write(out, contents)
    out.setExecutable(true)
    out
  }
}.value



//generate a single fat jar file with the assembly plugin

//Seq(assemblySettings: _*)

assembly / test := {}

assembly / assemblyJarName := s"../../../TypeChef-${version.value}.jar"


//packageScala / assembleArtifact := false

//packageSrc / assembleArtifact := false

assembly / assemblyMergeStrategy := {
  (assembly / assemblyMergeStrategy) { old =>
    (_: String) match {
      case f if f startsWith "org/fusesource/" => MergeStrategy.first
      case x => old(x)
    }
  }
}.value
