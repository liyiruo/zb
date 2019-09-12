package com.hx.zibiao;

import com.alibaba.druid.support.ibatis.SqlMapClientImplWrapper;
import com.hx.zibiao.bean.TestBean;
import com.hx.zibiao.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j  //加了这个注解 就可以在第25行直接使用log了，也可以用20行和32行的日志输出
public class ZibiaoApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
        TestBean testBean = (TestBean) applicationContext.getBean("testBean");

        //这里输出了值 说明@Value注解生效，注入到容器中的类生效
        System.out.println("testBean.name==========>" + testBean.getName());
    }

    @Autowired
    DataSource dataSource;

    @Test
    public void testDataBase() throws SQLException {
        //成功连接数据库
        Connection connection = dataSource.getConnection();
        System.out.println("connection====>" + connection.getClass());
        connection.close();
    }

    @Test
    public void test1() {
        String a = "99999999";
        String b = "8888888888888";
        log.info("=================》这种日志的输出格式{},{}", a, b);
        //TODO 该干点什么呢
    }


    @Autowired
    JdbcTemplate template;
    @Test
    public void test2() {
        List<Map<String, Object>> maps = template.queryForList("select sysdate from dual ");
        List<Map<String, Object>> maps2 = template.queryForList("select * from myuser ");
        log.info("==========>{}",maps.get(0));
        log.info("==========>{}",maps2.get(0));
    }
}
