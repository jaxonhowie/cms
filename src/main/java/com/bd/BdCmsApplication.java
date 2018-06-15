package com.bd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author Administrator
 */
@SpringBootApplication
@MapperScan("com.bd.dao.mapper")
@ServletComponentScan
public class BdCmsApplication  {

    public static void main(String[] args) {
        SpringApplication.run(BdCmsApplication.class, args);
    }
}
