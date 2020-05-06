package cn.mogeek.service;

import cn.mogeek.domain.Disciple;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Dictionary;
import java.util.List;

public class testQuery {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    Service service = (Service)applicationContext.getBean("service");

    @Test
    public void testQuery(){
        Disciple disciple = new Disciple();
        disciple.setMajor_subject("无限奥义循环");
        List<Disciple> discipleList = query(disciple);

        for (Disciple d:discipleList
             ) {
            System.out.println(d);
        }
        System.out.println("COUNT:" + discipleList.size());

        disciple.setMajor_subject("无限奥义循环 X 10086");
        disciple.setCome_from("U.K");
        discipleList = query(disciple);

        for (Disciple d:discipleList
        ) {
            System.out.println(d);
        }
        System.out.println("COUNT:" + discipleList.size());

    }

    public List<Disciple> query(Disciple disciple){
        List<Disciple> discipleList = service.query(disciple);
        return discipleList;
    }
}
