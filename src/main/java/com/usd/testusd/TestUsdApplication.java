package com.usd.testusd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TestUsdApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestUsdApplication.class, args);
    }

}
