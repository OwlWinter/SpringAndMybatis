package cn.mogeek.dao;

import cn.mogeek.domain.Disciple;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testUpdate {
    ApplicationContext applicationContext;
    DiscipleDao discipleDao;

    @Before
    public void init() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        discipleDao = (DiscipleDao)applicationContext.getBean("discipleDao");
    }



    @Test
    public void testUpdate() throws Exception {
        Disciple disciple = new Disciple();
        disciple.setId(113);
        disciple.setQq_num(666666);
        disciple.setStudent_name("暗灭");
        System.out.println(discipleDao.update(disciple));
    }
}
