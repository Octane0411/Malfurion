package com.malfurion.malfurionserver.common.config.swagger;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
//开启swagger2
@EnableSwagger2
public class SwaggerConfig {

    //配置swagger的docket的bean实例
    @Bean
    public Docket docket(Environment environment) {
        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev", "test");

        //获取生产环境
        //判断自己是否在profiles的环境中
        boolean flag = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("octane")
                .select()
                //配置扫描接口的方式
                //basePackage指定要扫描的包
                //any（）扫描全部
                //none（）不扫描
                //withClassAnnotation：扫描类上的注解，参数是一个注解的反射对象
                //withMethodAnnotation：扫描方法上的注解
                .apis(Predicates.or(
                        RequestHandlerSelectors.basePackage("com.malfurion.malfurionserver.admin.controller"),
                        RequestHandlerSelectors.basePackage("com.malfurion.malfurionserver.common.web.controller")))
                //过滤什么路径
                .build()
                .enable(flag);
    }

    //配置swagger信息=apiInfo
    private ApiInfo apiInfo() {

        //作者信息
        Contact contact = new Contact("octane", "https://www.baidu.com", "wdznb1@gmail.com");

        return new ApiInfo("Api Documentation",
                "Api Documentation",
                "1.0",
                "https://www.baidu.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}


