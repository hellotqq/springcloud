package com.tqq.openfreign1;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class Openfreign1Application {

    public static void main(String[] args) {
        SpringApplication.run(Openfreign1Application.class, args);
    }
    @Bean
    Logger.Level loggerLevel(){
        return Logger.Level.FULL;
    }
}
