package com.telusk.springbootbookstore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;

import static springfox.documentation.swagger.web.UiConfigurationBuilder.builder;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("User")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.telusk.springbootbookstore.user.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket bookApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Book")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.telusk.springbootbookstore.books.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    @Bean
    UiConfiguration uiConfig() {
        return builder()
                .build();
    }
}
