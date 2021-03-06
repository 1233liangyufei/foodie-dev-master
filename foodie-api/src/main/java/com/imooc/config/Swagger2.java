package com.imooc.config;

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

@Configuration
@EnableSwagger2
public class Swagger2 {

    //    http://localhost:8088/swagger-ui.html     原路径
    //    http://localhost:8088/doc.html     原路径
    //配置swagger2核心配置 docket
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)  //api类型为swagger2
                .apiInfo(apiInfo())                 //用于定义api文档汇总信息
                .select()
                .apis(RequestHandlerSelectors
                .basePackage("com.imooc.controller"))   // 指定controller包
                .paths(PathSelectors.any())    //所有的controller包
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("天天吃货电商平台接口文档")  //文档标题
                .contact(new Contact("imooc",
                        "https://www.imooc.com",
                        "abc@imooc.com"))  //联系人
                .description("天天吃货的api文档")  //描述信息
                .version("1.0.1")
                .termsOfServiceUrl("https://www.immoc.com")  //网站
                .build();
    }
}
