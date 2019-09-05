package com.nacos.ehr.common.gateway.annotation;

import com.nacos.ehr.common.gateway.configuration.DynamicRouteAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author yangbin
 * @date 2019年09月04日
 * <p>
 * 开启ehr 动态路由
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(DynamicRouteAutoConfiguration.class)
public @interface EnablEhrDynamicRoute {
}
