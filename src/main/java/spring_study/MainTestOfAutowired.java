package spring_study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_study.bean.Boss;
import spring_study.bean.Car;
import spring_study.config.MainConfigOfAutowired;
import spring_study.config.MainConfigOfPropertyValue;
import spring_study.dao.TestDao;
import spring_study.service.TestService;

/**
 * Created by wangyang on 2019/4/4.
 */
public class MainTestOfAutowired {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        System.out.println("IOC容器创建完成");
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String name:beanNames) {
            System.out.println(name);
        }
        /*TestService service = (TestService) applicationContext.getBean("testService");
        service.printTestDao();

        TestDao dao = (TestDao) applicationContext.getBean("testDao");
        System.out.println("lable in IOC: " + dao.getLable());*/

        Car car = applicationContext.getBean(Car.class);
        System.out.println("car in IOC: " + car);

        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println("car in BOSS: " + boss.getCar());

        applicationContext.close();
    }
}
