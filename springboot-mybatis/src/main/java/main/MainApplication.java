package main;

import main.annotations.EnableAutoProxy;
import main.dao.TestDao;
import main.domain.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2020-12-08
 **/
@SpringBootApplication
@MapperScan("main.dao")
@EnableAutoProxy("main.demo")
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class);
        TestDao testDao = context.getBean(TestDao.class);
//        System.out.println(testDao.get(1));
//        TestService testService = context.getBean(TestService.class);
//        testService.getWithTransaction();
//        System.out.println(testDao.get(1));
        List<Test> tests = new ArrayList<>();
        for (int i = 0; i < 3 ; i++) {
            Test test = new Test();
            test.setTest1(1);
            test.setTest2(2);
            test.setTest3(3);
            tests.add(test);
        }
        testDao.addTest(tests);
    }
}
