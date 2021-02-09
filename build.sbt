val Organization = "com.github.fedeoasi"
val Name = "Algorithms Exercises"
val Version = "0.1.0-SNAPSHOT"
val ScalaVersion = "2.11.7"

organization := Organization
name := Name
version := Version
mainClass := Some("com.github.fedeoasi.Main")
scalaVersion := "2.11.7"
resolvers += Classpaths.typesafeReleases
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
)