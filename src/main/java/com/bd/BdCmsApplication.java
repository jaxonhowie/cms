package com.bd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author Administrator
 */
@MapperScan(basePackages = {"com.bd.model.mapper"})
@SpringBootApplication
@ServletComponentScan
public class BdCmsApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow", "|{}");
        SpringApplication.run(BdCmsApplication.class, args);
    }
}
