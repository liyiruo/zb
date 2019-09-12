package com.hx.zibiao.config;


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
//    这个方法名不能使用druidConfig()
    public DataSource druid() {
//        DataSource dataSource = new DruidDataSource();
//        ((DruidDataSource) dataSource).setAsyncInit(true);
//        ((DruidDataSource) dataSource).setInitialSize(5);
        return new DruidDataSource();
    }
    /**
     * 配置druid的监控
     */
//1.配置druid的后台的servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map map = new HashMap();
        map.put(StatViewServlet.PARAM_NAME_USERNAME, "root");
        map.put(StatViewServlet.PARAM_NAME_PASSWORD, "root");
        map.put(StatViewServlet.PARAM_NAME_ALLOW, "");
        map.put(StatViewServlet.PARAM_NAME_DENY, "192.168.1.9");
        bean.setInitParameters(map);
        return bean;
    }

    //2.配置一个druid的filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String, String> initMap = new HashMap<>();
        // 不拦截
        initMap.put(WebStatFilter.PARAM_NAME_EXCLUSIONS, "*.css,*.js,/druid/*");
        bean.setInitParameters(initMap);
        // 拦截那些请求
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }


}
