package cn.mogeek.dao;

import cn.mogeek.domain.Disciple;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class testQuery {
    ApplicationContext applicationContext;
    DiscipleDao discipleDao;

    @Before
    public void init() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        discipleDao = (DiscipleDao)applicationContext.getBean("discipleDao");
    }

    @Test
    public void testQuery() throws Exception{
        Disciple disciple = new Disciple();
        disciple.setStudent_name("奇异博士-NO:1");
        List<Disciple> discipleList = discipleDao.query(disciple);
      /*  for (Disciple singleOne: discipleList){
            System.out.println(singleOne);
        }*/
        System.out.println("共查询到结果：" + discipleList.size());
    }

}
