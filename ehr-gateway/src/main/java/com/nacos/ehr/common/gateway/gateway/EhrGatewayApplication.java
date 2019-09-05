package com.nacos.ehr.common.gateway.gateway;

import com.nacos.ehr.common.gateway.annotation.EnablEhrDynamicRoute;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author yangbin
 * @date 2019年09月04日
 * ehr
 */
@EnablEhrDynamicRoute
@SpringCloudApplication
public class EhrGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(EhrGatewayApplication.class, args);
    }
}
