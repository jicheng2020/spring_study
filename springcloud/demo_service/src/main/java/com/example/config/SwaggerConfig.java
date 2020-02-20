package com.example.config;

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
 * @author JC
 * @date 16:03 2020/2/20
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        // 配置swagger生成api的扫描范围
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.example")).paths(PathSelectors.any()).build();
    }

    /**
     * 创建api文档信息
     *
     * @return springfox.documentation.service.ApiInfo
     * @autor JC
     * @date 16:08 2020/2/20
     **/
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("title").description("test").termsOfServiceUrl("").version("1.0").build();
    }
}
