import Dependencies._

version := "0.1"

scalaVersion := "2.12.8"

organization := "pg.kata"

lazy val sharedDependencies = Seq(`scala-logging`, scalatest)

lazy val `domain-boundaries` = project.settings(name := "domain-boundaries")

lazy val `domain-core` = project
  .dependsOn(`domain-boundaries`)
  .settings(
    libraryDependencies ++= sharedDependencies,
    name := "domain-core"
  )

lazy val root = (project in file("."))
  .aggregate(`domain-boundaries`, `domain-core`)
  .dependsOn(`domain-boundaries`, `domain-core`)
  .settings(name := "wallet")
