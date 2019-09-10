package com.nacos.ehr.common.datasource.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yangbin
 * @date 2019年09月06日
 * <p>
 * 参考DruidDataSourceWrapper
 */
@Data
@Component
@ConfigurationProperties("spring.datasource.druid")
public class DruidDataSourceProperties {
    private String username;
    private String password;
    private String url;
    private String driverClassName;
}