package com.rjxz.xykd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.rjxz.xykd.dao")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class XykdApplication {

    public static void main(String[] args) {
        SpringApplication.run(XykdApplication.class, args);
    }

}
