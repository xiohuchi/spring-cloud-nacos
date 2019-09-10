package com.nacos.ehr.user;

import com.nacos.ehr.common.swagger.annotation.EnableEhrSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author yangbin
 * @date 2019年09月06日
 * <p>
 * 用户统一管理系统
 */
@EnableEhrSwagger2
@SpringCloudApplication
public class EhrUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(EhrUserApplication.class, args);
    }
}
