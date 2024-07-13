import org.springframework.context.annotation.{Bean, Configuration};
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.{
  RequestHandlerSelectors,
  PathSelectors
};
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
class SwaggerConfig {

  @Bean
  def api(): Docket = {
    new Docket(DocumentationType.SWAGGER_2)
      .select()
      .apis(
        RequestHandlerSelectors.withClassAnnotation(classOf[RestController])
      )
      .paths(PathSelectors.any())
      .build()
  }
}
