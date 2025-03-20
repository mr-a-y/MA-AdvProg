ThisBuild / scalaVersion := "3.6.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "homework2",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "3.6.0",
    scalacOptions += "-language:reflectiveCalls"
  )
