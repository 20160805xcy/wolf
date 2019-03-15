package com.xcy.wolf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@ServletComponentScan
@SpringBootApplication
@MapperScan(basePackages = {"com.xcy.wolf.mapper"})
//@ComponentScan(basePackages= "com.xcy.wolf.handler")
public class WolfApplication {

    public static void main(String[] args) {
        SpringApplication.run(WolfApplication.class, args);
    }
}
