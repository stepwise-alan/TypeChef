addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "latest.integration")

//addCompilerPlugin("org.scala-tools.sxr" % "sxr_2.9.0" % "latest.integration")

//resolvers += Resolver.url("sbt-plugin-releases_", new URL("https://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)

addSbtPlugin("com.github.sbt" % "sbt-pgp" % "latest.integration")


resolvers += Classpaths.sbtPluginReleases

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "latest.integration")

addSbtPlugin("org.scoverage" %% "sbt-coveralls" % "latest.integration")
