package com.rjxz.xykd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class JavaConfig {

    @Bean
    public JavaMailSender mailSender(){

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.smtp.socketFactory.fallback", "true");
        mailSender.setJavaMailProperties(javaMailProperties);
        mailSender.setProtocol("smtp");
        mailSender.setHost("smtp.sina.com");
        mailSender.setPort(25);
        mailSender.setUsername("hsxywwj@sina.com");
        mailSender.setPassword("a12345678@WWJ");
        mailSender.setDefaultEncoding("utf-8");
        return mailSender;
    }



}
