name := "github_bot"

version := "1.0"

lazy val `github_bot` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "net.caoticode.buhtig" %% "buhtig" % "0.3.1",
  "com.github.tototoshi" %% "play-json4s-jackson" % "0.5.0",
  "com.github.scopt" %% "scopt" % "3.5.0",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0" % "test",
  "org.scalamock" %% "scalamock-scalatest-support" % "3.2.2" % "test"
)

resolvers ++= Seq(
  "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

