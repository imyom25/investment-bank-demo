package com.investment.bank.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().build();
    }
//
//    private Predicate<String> postPaths() {
//        return or(regex("/v1/*"));
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Investment Banking API")
                .description("API reference for developers")
                .termsOfServiceUrl("")
                .contact(new Contact("InvestmentBanking","localhost:8090","@gmail.com"))
                .license("@imyom25 License").licenseUrl("").version("1.0").build();
    }

}