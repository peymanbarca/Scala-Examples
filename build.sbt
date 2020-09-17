name := "scala-basic-examples"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "commons-logging" % "commons-logging" % "1.1.1"

libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.1.2"

libraryDependencies += "org.mongodb" % "mongo-java-driver" % "2.10.1"


resolvers ++= Seq(
  "Scala-Tools Maven2 Releases Repository" at "http://scala-tools.org/repo-releases",
  "Scala-Tools Maven2 Snapshots Repository" at "http://scala-tools.org/repo-snapshots"
)

libraryDependencies += "com.github.etaty" %% "rediscala" % "1.7.0"

libraryDependencies += "org.postgresql" % "postgresql" % "9.3-1102-jdbc41"

libraryDependencies ++= Seq(
  "com.h2database" % "h2" % "1.2.137",
  "org.squeryl" % "squeryl_2.10" % "0.9.5-6"
)

libraryDependencies += "net.ruippeixotog" %% "scala-scraper" % "2.2.0"

libraryDependencies += "com.google.code.gson" % "gson" % "2.2.4"

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4"

libraryDependencies +=
  "com.typesafe.akka" %% "akka-actor" % "2.3.16"

