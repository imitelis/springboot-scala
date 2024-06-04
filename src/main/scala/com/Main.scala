package com

import org.springframework.boot.SpringApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class Application extends SpringBootServletInitializer {
  override def configure(application: SpringApplicationBuilder): SpringApplicationBuilder = {
    application.sources(classOf[Application])
  }
}

object Main extends App {
  SpringApplication.run(classOf[Application], args: _*)
}