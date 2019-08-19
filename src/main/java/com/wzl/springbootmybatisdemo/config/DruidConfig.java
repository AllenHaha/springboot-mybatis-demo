package com.wzl.springbootmybatisdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    DataSource druid(){
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean stateViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> parameterMap = new HashMap();
        parameterMap.put("loginUsername", "admin");
        parameterMap.put("loginPassword", "123456");
        parameterMap.put("allow", "");
        parameterMap.put("deny", "192.168.120.32");
        bean.setInitParameters(parameterMap);
        return bean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        Map<String,String> parameterMap = new HashMap();
        parameterMap.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(parameterMap);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
