import sbt._

object Dependencies {
  lazy val `scala-logging` = "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"
  lazy val scalatest = "org.scalatest" %% "scalatest" % "3.0.6" % Test
}
