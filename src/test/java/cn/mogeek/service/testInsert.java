package cn.mogeek.service;

import cn.mogeek.dao.DiscipleDao;
import cn.mogeek.domain.Disciple;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testInsert {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    Service service = (Service) applicationContext.getBean("service");

    @Test
    public void testInsert(){
        Disciple disciple = new Disciple();
        disciple.setMajor_subject("无限奥义循环");
        disciple.setCome_from("英国");
        disciple.setDaily_report("https://baike.baidu.com/item/%E5%A5%87%E5%BC%82%E5%8D%9A%E5%A3%AB/2492942");
        disciple.setBrother("古一法师");
        disciple.setSlogan("多玛姆，我是来找你谈判的！");
        disciple.setGraduated_school("格林威治村");

        Disciple temp = null;
        try {
            temp = (Disciple)disciple.clone();
        }catch (CloneNotSupportedException e){
            System.out.println(e);
            return;
        }

        long num;
        for (int i = 1; i <= 10; i ++){
            num = System.currentTimeMillis();
            temp.setQq_num((int)(num % 100000));
            temp.setStudent_id((int)(num % 10000));
            temp.setStudent_name("奇异博士-NO:" + i);
            int ass = service.insert(temp);
            Assert.assertTrue(ass != -1);
        }
    }
}
