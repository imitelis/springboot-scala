name := "springboot-scala"

version := "1.0"

scalaVersion := s"2.13.14"

// Run in a separate JVM, to make sure sbt waits until all threads have
// finished before returning.
// If you want to keep the application running while executing other
// sbt tasks, consider https://github.com/spray/sbt-revolver/
fork := true

libraryDependencies ++= Seq(
  // Springboot
  "org.springframework.boot" % "spring-boot-starter-web" % "2.6.7",
  "org.springframework.boot" % "spring-boot-configuration-processor" % "2.6.7",
  "org.springframework.boot" % "spring-boot-devtools" % "2.6.7",
  "org.springframework.boot" % "spring-boot-starter-test" % "2.6.7",
  // Swagger
  "io.springfox" % "springfox-swagger2" % "3.0.0",
  "io.springfox" % "springfox-swagger-ui" % "3.0.0",
  "io.springfox" % "springfox-boot-starter" % "3.0.0",
  // Circe
  "io.circe" %% "circe-core" % "0.14.9",
  "io.circe" %% "circe-generic" % "0.14.9",
  "io.circe" %% "circe-parser" % "0.14.9",
  // Jackson
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.12.4"
)

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-encoding",
  "utf8",
  "-feature",
  "-language:postfixOps",
  "-language:implicitConversions",
  "-Ymacro-annotations"
)
