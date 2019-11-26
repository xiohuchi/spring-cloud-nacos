package com.dianmi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author yangbin
 * @date 2018/07/29
 * 代码生成模块
 */
@SpringCloudApplication
@MapperScan("com.dianmi.mapper")
public class EhrCodeGenApplication {


    public static void main(String[] args) {
        SpringApplication.run(EhrCodeGenApplication.class, args);
    }
}
