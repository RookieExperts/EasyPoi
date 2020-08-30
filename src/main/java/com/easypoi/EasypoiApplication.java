package com.easypoi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.easypoi.mapper")
public class EasypoiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasypoiApplication.class, args);
    }

}
