package com.student.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/student/*"))
                .build()
                .apiInfo(apiEndPointsInfo())
                ;
   }

	private ApiInfo apiEndPointsInfo() {
	    return new ApiInfoBuilder().title("Spring Boot Student Application CURD operations")
	        .description("Student Management REST API")
	        .contact(new Contact("DVG", null, "dvgnaveenkumarreddy@gmail.com"))
	        .license("test")
	        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
	        .version("1.0.0")
	        .build();
	}
}
