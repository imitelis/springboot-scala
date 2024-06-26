// SwaggerConfig.scala
package com.config

import org.springframework.context.annotation.{Bean, Configuration}
import springfox.documentation.builders.{PathSelectors, RequestHandlerSelectors}
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

  @Bean
  def api(): Docket = {
    new Docket(DocumentationType.SWAGGER_2)
      .select()
      .apis(
        RequestHandlerSelectors.basePackage("com.controllers")
      ) // Adjust package scan as per your controllers' package
      .paths(PathSelectors.any())
      .build()
  }
}
