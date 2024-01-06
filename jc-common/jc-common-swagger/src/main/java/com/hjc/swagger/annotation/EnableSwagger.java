package com.hjc.swagger.annotation;

import com.hjc.swagger.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author hjc
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(SwaggerAutoConfiguration.class)
public @interface EnableSwagger {

}
