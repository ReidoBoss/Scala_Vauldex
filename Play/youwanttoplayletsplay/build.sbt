name := """youwanttoplayletsplay"""
organization := "com.letsplay"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "3.3.1"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.letsplay.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.letsplay.binders._"
