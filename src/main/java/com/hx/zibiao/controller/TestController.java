package com.hx.zibiao.controller;

import com.hx.zibiao.pojo.User;
import com.hx.zibiao.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j  //加了这个注解 就可以在第25行直接使用log了，也可以用20行和32行的日志输出
@Controller
@RequestMapping("test")
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("test")
    @ResponseBody
    public String test() {
        log.info("TestController=========>");
        return "这是一个测试啊";
    }

    @RequestMapping("index")
    public String index() {
        String a = "6666666777777777";
        logger.info("这是个什么呢+{}", a);
        return "index";
    }


    @Autowired
    JdbcTemplate template;


    @RequestMapping("get")
    @ResponseBody
    public List<Map<String, Object>> get() {
        logger.info("TestController=========>get");

        List<Map<String, Object>> maps = template.queryForList("select * from myuser ");
        //JdbcTemplate 成功查询出值
        logger.info(maps.toString());
        return maps;
    }


    @RequestMapping("add")
    @ResponseBody
    public Integer add() {
        logger.info("TestController=========>add");
        int i = template.update("insert into myuser values (2,'王五')");
        logger.info("成功执行了" + i + "条");

        return i;
    }

//    测试接口和service

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "addUser")
    public Map addUser(@NotNull User user) {
        Map map = new HashMap();
        int i = userService.addUser(user);
        map.put(1, i);
        map.put(2, user);
        return map;

    }


    @ResponseBody
    @RequestMapping(value = "getAll")
    public List<User> getAllUser() {
        List<User> list = userService.getUsers();
        log.info("查询出的所有{}",list);
        return list;

    }



    @ResponseBody
    @RequestMapping(value = "getAlls")
    public List<User> getAllUser1() {
        return userService.testT();

    }
}
