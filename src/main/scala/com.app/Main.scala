package com.app

import springfox.documentation.swagger2.annotations.EnableSwagger2

import org.springframework.boot.SpringApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages =
  Array("com.app", "com.app.config", "com.app.controllers")
)
class Application extends SpringBootServletInitializer {
  override def configure(
      application: SpringApplicationBuilder
  ): SpringApplicationBuilder = {
    application.sources(classOf[Application])
  }
}

object Main extends App {
  SpringApplication.run(classOf[Application], args: _*)
}
