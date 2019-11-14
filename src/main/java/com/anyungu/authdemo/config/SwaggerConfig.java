package com.anyungu.authdemo.config;

import org.springframework.context.annotation.Bean;


import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



//Swagger class fora documentation

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String API_VERSION = "1.0";
	private static final String API_TITLE = "TEST API 2019";
	private static final String API_DESCRIPTION = "Auth Test API";
	private static final String LICENSE_TEXT = "Pending Licences";
	private static final String LICENSE_URL = "";

	private static final String DEVELOPER_NAME = "Anyungu C.";
	private static final String DEVELOPER_URL = "";
	private static final String DEVELOPER_EMAIL = "anyungucw@gmail.com";

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().version(API_VERSION).title(API_TITLE).description(API_DESCRIPTION)
				.license(LICENSE_TEXT).licenseUrl(LICENSE_URL)
				.contact(new Contact(DEVELOPER_NAME, DEVELOPER_URL, DEVELOPER_EMAIL)).build();
	}

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.anyungu.authdemo.controllers")).paths(PathSelectors.any())
				.build();
	}
}
