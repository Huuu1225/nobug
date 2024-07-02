package com.cqdx.nobug;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cqdx.nobug.mapper")
public class NobugApplication {

    public static void main(String[] args) {
        SpringApplication.run(NobugApplication.class, args);
    }

}
