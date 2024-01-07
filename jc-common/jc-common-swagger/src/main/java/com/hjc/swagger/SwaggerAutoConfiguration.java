package com.hjc.swagger;

import com.hjc.swagger.annotation.EnableSwagger;
import com.hjc.swagger.properties.SwaggerProperties;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类
 * @author hjc
 */
@Configuration
@ConditionalOnClass({EnableSwagger.class})
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerAutoConfiguration {

    @Bean
    public OpenAPI springShopOpenAPI(SwaggerProperties swaggerProperties) {
        return new OpenAPI()
                // 接口文档标题
                .info(new Info().title(swaggerProperties.getTitle())
                        // 接口文档简介
                        .description(swaggerProperties.getDescription())
                        // 接口文档版本
                        .version(swaggerProperties.getVersion())
                        // 开发者联系方式
                        .contact(new Contact().name(swaggerProperties.getContact().getName())
                                .email(swaggerProperties.getContact().getEmail())))
                .externalDocs(new ExternalDocumentation()
                        .description(swaggerProperties.getExternalDocs().getDescription())
                        .url(swaggerProperties.getExternalDocs().getUrl()));
    }
}
