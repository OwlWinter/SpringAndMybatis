package cn.mogeek.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testDelete {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    Service service = (Service)applicationContext.getBean("service");

    @Test
    public void testDelete(){
        Assert.assertTrue(service.delete(30000009));
    }
}
