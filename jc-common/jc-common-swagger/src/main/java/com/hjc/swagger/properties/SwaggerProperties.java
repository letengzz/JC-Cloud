package com.hjc.swagger.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * swagger 配置
 * @author hjc
 */
@Data
@ConfigurationProperties(prefix = "jc.swagger")  //此属性类和配置文件指定前缀绑定
public class SwaggerProperties {
    private String title = "API接口文档";
    private String description = "接口文档";
    private String version = "v1.0";
    private Contact contact = new Contact();
    private ExternalDocs externalDocs = new ExternalDocs();
    @Data
    public static class Contact {
        private String name = "hjc";
        private String email = "2020885569@qq.com";
    }

    @Data
    public static class ExternalDocs {
        private String description = "hjc";
        private String url = "http://127.0.0.1:8080";
    }
}
