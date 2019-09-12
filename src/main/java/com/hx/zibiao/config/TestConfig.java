package com.hx.zibiao.config;

import com.hx.zibiao.bean.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    /**
     *这个类里可以写各种配置的bean,将其注入到容器
     */
    @Bean
    public TestBean testBean() {
        TestBean testBean = new TestBean();
        return testBean;
    }
}
