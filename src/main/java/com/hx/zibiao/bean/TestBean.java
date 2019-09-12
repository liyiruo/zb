package com.hx.zibiao.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

/**
 * @Data 这个注解不用写getter和setter方法
 * https://projectlombok.org/ 学习lombok
 *
 */
@Data
//@PropertySource(value = "") 这个注解也可以赋值
public class TestBean {

   @Value("testzhangshan")//这个注解是用来赋值的
   private String name;
   private int age;
   private List list;
   private Map map;
}
