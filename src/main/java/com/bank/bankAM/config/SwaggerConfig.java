package com.bank.bankAM.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final String AUTHORIZATION_HEADER = "Authorization";

    private ApiKey apiKey(){
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
    }

    @Bean
    public Docket SwaggerConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.bank.bankAM"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "BAMCo Report API",
                "An API for workflow management.",
                "1.0",
                "Free to use",
                new Contact("Med Idbihi", "https://github.com/Mohamedidbihi","https://github.com/Mohamedidbihi"),
                "Free License",
                "https://github.com/Mohamedidbihi/BAMCo",
                Collections.emptyList()
        );
    }
    private SecurityContext securityContext(){
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }
}
