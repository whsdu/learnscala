lazy val commonSettings = Seq(
  organization := "emmettng.com",
  version := "0.0.1",
  scalaVersion := "2.11.8"
)
lazy val hello = taskKey[Unit]("An example task hello !")

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "testProject3",
    hello := {println(" Hello whsdu")}
  )
resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % "2.11.8",
  "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.4",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test",
  "com.typesafe.play" %% "play-json" % "2.4.0-M3",
  "org.scalaz" %% "scalaz-core" % "7.2.5",
  "junit" % "junit" % "4.10" % "test"
)
