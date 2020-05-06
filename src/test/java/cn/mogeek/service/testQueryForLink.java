package cn.mogeek.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class testQueryForLink {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    Service service = (Service)applicationContext.getBean("service");

    @Test
    public void testQueryForLink(){
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("name", "奇异博士-NO:1");
        System.out.println(service.queryForLink(stringStringMap));

        stringStringMap.put("id", "5339");
        System.out.println(service.queryForLink(stringStringMap));

        stringStringMap.replace("name", "奇异博士-NO:2");
        System.out.println(service.queryForLink(stringStringMap));
        System.out.println(new String("").getClass());
    }
}
