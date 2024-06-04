name := "finagle-scala"

version := "1.0"

scalaVersion := s"2.13.10"

// Run in a separate JVM, to make sure sbt waits until all threads have
// finished before returning.
// If you want to keep the application running while executing other
// sbt tasks, consider https://github.com/spray/sbt-revolver/
fork := true

libraryDependencies ++= Seq(
  // Spring Boot dependencies
  "org.springframework.boot" % "spring-boot-starter-web" % "2.6.7",
  "org.springframework.boot" % "spring-boot-configuration-processor" % "2.6.7",
  // Swagger
  "io.springfox" % "springfox-swagger2" % "2.9.2",
  "io.springfox" % "springfox-swagger-ui" % "2.9.2"
  // "org.springdoc" % "springdoc-openapi-starter-webmvc-ui" % "2.5.0"
)

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-encoding", "utf8",
  "-feature",
  "-language:postfixOps",
  "-language:implicitConversions"
)