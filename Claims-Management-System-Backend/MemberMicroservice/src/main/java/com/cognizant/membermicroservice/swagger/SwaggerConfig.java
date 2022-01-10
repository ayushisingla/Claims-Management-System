package com.ayushi.membermicroservice.swagger;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * This class is used for the configuration and customization of swagger.
 * Swagger is used to describe and document RESTful APIs with Swagger user will
 * able to see the end-points to access the application.
 *
 */

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	/**
	 * 
	 * @return Docket object We are creating a Docket bean in a Spring Boot
	 *         configuration to configure Swagger 2 for the application. A Springfox
	 *         Docket instance provides the primary API configuration with sensible
	 *         defaults and convenience methods for configuration
	 *
	 */

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ayushi.membermicroservice.controller"))
				.paths(regex("/.*")).build();
	}

}