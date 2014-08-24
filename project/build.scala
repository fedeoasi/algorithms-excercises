import sbt._
import Keys._

object SensorCheckBuild extends Build {
  val Organization = "com.github.fedeoasi"
  val Name = "Sensor Check"
  val Version = "0.1.0-SNAPSHOT"
  val ScalaVersion = "2.10.4"

  lazy val project = Project (
    "sensor-check",
    file("."),
    settings = Defaults.defaultSettings ++ Seq(
      organization := Organization,
      name := Name,
      version := Version,
      mainClass := Some("com.github.fedeoasi.Main"),
      scalaVersion := ScalaVersion,
      resolvers += Classpaths.typesafeReleases,
      libraryDependencies ++= Seq(
        "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"
      )
    )
  )
}
