package com.bd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Administrator
 */
@MapperScan(basePackages = {"com.bd.model.mapper"})
@SpringBootApplication
@ServletComponentScan
@ComponentScan(basePackages = { "com" })
public class BdCmsApplication  {

    public static void main(String[] args) {
        System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow", "|{}");
        SpringApplication.run(BdCmsApplication.class, args);
    }
}
