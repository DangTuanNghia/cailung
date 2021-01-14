name := "skinnyBook"

version := "1.0"

lazy val `skinnybook` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"

scalaVersion := "2.12.2"

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice )
libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "8.0.11",
  "org.skinny-framework" %% "skinny-orm"      % "3.0.3",
  "org.skinny-framework" %% "skinny-task" % "3.0.3",
  "org.scalikejdbc"      %% "scalikejdbc-play-initializer" % "2.8.0-scalikejdbc-3.5"
)
