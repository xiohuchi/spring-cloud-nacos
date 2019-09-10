package com.nacos.ehr.common.swagger.annotation;

import com.nacos.ehr.common.swagger.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author yangbin
 * @date 2019年09月06日
 * <p>
 * 开启ehr swagger
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SwaggerAutoConfiguration.class})
public @interface EnableEhrSwagger2 {
}
