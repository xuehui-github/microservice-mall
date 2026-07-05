package com.xue.divisionsservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.xue.divisionsservice.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class DivisionsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DivisionsServiceApplication.class, args);
    }

}
