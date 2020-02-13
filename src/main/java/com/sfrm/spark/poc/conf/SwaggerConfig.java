package com.sfrm.spark.poc.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Visit http://localhost:8080/spring-hive-integration/swagger-ui.html URL for Swagger Doc
 * 
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .apiInfo(apiInfo())
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.sfrm.hive.poc.controller"))              
          .paths(PathSelectors.ant("/**"))   
          .build();                                           
    }
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Hive POC API")
				.description("Hive POC API")
				.version("1.0").build();
	}
}
