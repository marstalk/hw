package com.classm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan(value = "com.classm.dao.mapper")
public class HwApplication {

    public static void main(String[] args) {
        SpringApplication.run(HwApplication.class, args);
    }

}

