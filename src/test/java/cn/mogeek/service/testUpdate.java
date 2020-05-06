package cn.mogeek.service;

import cn.mogeek.domain.Disciple;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testUpdate {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    Service service = (Service)applicationContext.getBean("service");

    @Test
    public void testUpdate(){
        Disciple disciple = new Disciple();
        disciple.setId(30000001);
        disciple.setMajor_subject("无限奥义循环 X 10086");
        disciple.setCome_from("U.K");

        Assert.assertTrue(service.update(disciple));
    }
}
