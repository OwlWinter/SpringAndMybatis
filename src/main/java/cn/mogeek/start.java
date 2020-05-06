package cn.mogeek;


import org.springframework.context.ApplicationContext;
import java.util.List;
import cn.mogeek.domain.Disciple;
import cn.mogeek.dao.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Test{
    public void testInsert(DiscipleDao discipleDao) throws Exception{
        Disciple disciple = new Disciple();
        disciple.setQq_num(100000);
        disciple.setMajor_subject("无限奥义循环");
        disciple.setStudent_name("奇异博士-NO:");
        disciple.setCome_from("英国");
        disciple.setDaily_report("https://baike.baidu.com/item/%E5%A5%87%E5%BC%82%E5%8D%9A%E5%A3%AB/2492942");
        disciple.setBrother("古一法师");
        disciple.setSlogan("打败多玛姆");
        disciple.setGraduated_school("格林威治村");

        Disciple temp = (Disciple)disciple.clone();
        for (int i = 10000; i > 0; i --){
            temp.setQq_num(disciple.getQq_num() + i);
            temp.setStudent_name(disciple.getStudent_name() + String.valueOf(i));
            discipleDao.insert(temp);
        }

    }

    public void testUpdate(DiscipleDao discipleDao) throws Exception {
        Disciple disciple = new Disciple();
        disciple.setId(1013);
        disciple.setQq_num(666666);
        disciple.setStudent_name("暗灭");
        System.out.println(discipleDao.update(disciple));
    }


    public void testQuery(DiscipleDao discipleDao) throws Exception{
        Disciple disciple = new Disciple();
        disciple.setStudent_name("暗灭");
        List<Disciple> discipleList = discipleDao.query(disciple);
        for (Disciple singleOne: discipleList){
            System.out.println(singleOne);
        }
        System.out.println("共查询到结果：" + discipleList.size());
    }

    public void testDelete(DiscipleDao discipleDao) throws Exception{
        System.out.println(discipleDao.delete(1013));
    }
}

public class start{


    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DiscipleDao discipleDao = (DiscipleDao)applicationContext.getBean("discipleDao");

        try {
            Test test = new Test();
            test.testInsert(discipleDao);
            test.testUpdate(discipleDao);
            test.testQuery(discipleDao);
            test.testDelete(discipleDao);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}

