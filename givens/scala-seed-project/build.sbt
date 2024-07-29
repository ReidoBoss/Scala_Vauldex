import Dependencies._

ThisBuild / scalaVersion     := "3.3.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "stsagarino-07292024"

lazy val root = (project in file("."))
  .settings(
    name := "stsagarino-07292024",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" 
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
