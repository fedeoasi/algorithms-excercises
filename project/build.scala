import sbt._
import Keys._

object AlgorithmsExercisesBuild extends Build {
  val Organization = "com.github.fedeoasi"
  val Name = "Algorithms Exercises"
  val Version = "0.1.0-SNAPSHOT"
  val ScalaVersion = "2.11.7"

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
        "org.scalatest" %% "scalatest" % "2.2.6" % "test"
      )
    )
  )
}
