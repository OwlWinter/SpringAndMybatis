package cn.mogeek.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testDelete {
    ApplicationContext applicationContext;
    DiscipleDao discipleDao;

    @Before
    public void init() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        discipleDao = (DiscipleDao)applicationContext.getBean("discipleDao");

    }

    @Test
    public void testDelete() throws Exception{
        System.out.println(discipleDao.delete(112));
    }
}
