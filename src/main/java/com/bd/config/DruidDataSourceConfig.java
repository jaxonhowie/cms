package com.bd.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;

/**
 * Druid的DataResource配置类
 * @author Raye
 * @since 2016年10月7日14:14:18
 */
@Configuration
public class DruidDataSourceConfig  implements EnvironmentAware {

    private Logger logger = LoggerFactory.getLogger(DruidDataSourceConfig.class);

    private RelaxedPropertyResolver propertyResolver;


    @Override
    public void setEnvironment(Environment env) {
                this.propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
    }

    @Bean
    public DataSource dataSource() {
        logger.info("注入druid！！！");
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(propertyResolver.getProperty("url"));
        datasource.setDriverClassName(propertyResolver.getProperty("driverClassName"));
        datasource.setUsername(propertyResolver.getProperty("username"));
        datasource.setPassword(propertyResolver.getProperty("password"));
        datasource.setInitialSize(Integer.valueOf(propertyResolver.getProperty("initialSize")));
        datasource.setMinIdle(Integer.valueOf(propertyResolver.getProperty("minIdle")));
        datasource.setMaxWait(Long.valueOf(propertyResolver.getProperty("maxWait")));
        datasource.setMaxActive(Integer.valueOf(propertyResolver.getProperty("maxActive")));
        datasource.setMinEvictableIdleTimeMillis(Long.valueOf(propertyResolver.getProperty("minEvictableIdleTimeMillis")));
        try {
			datasource.setFilters("stat,wall,stat,log4j,default");
		} catch (Exception e) {
			e.printStackTrace();
            logger.error("初始化DataSource失败",e);
		}
        return datasource;
    }

    @Bean
    public MapperScannerConfigurer scannerConfigurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.bd.**.mapper");
        configurer.setMarkerInterface(Mapper.class);
        return configurer;
    }

}
