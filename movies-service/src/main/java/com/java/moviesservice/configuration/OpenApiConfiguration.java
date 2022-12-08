package com.java.moviesservice.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(info =
    @Info(title = "Movies API",
    version = "v1",
    description = "Documentarion of Movies API"))
public class OpenApiConfiguration {

  @Bean
  OpenAPI customOpenApi() {
    return new OpenAPI()
        .components(new Components())
        .info(
            new io.swagger.v3.oas.models.info.Info()
            .title("Movies API")
            .version("v1")
            .license(
                new License()
                  .name("Apache 2.0")
                  .url("http://springdoc.org")
            )
        );
  }
}

