package spring_study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_study.bean.Person;
import spring_study.config.MainConfig;
import spring_study.service.TestService;

/**
 * Created by wangyang on 2019/3/10.
 */
public class MainTest {

    public static void main(String[] args) {
        // 原来的从配置文件中加载Bean的方式
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);*/

        // 基于注解的Bean加载方式
        /*AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        //Person person = (Person) annotationConfigApplicationContext.getBean(Person.class);
        Person person = (Person) annotationConfigApplicationContext.getBean("ppp");
        System.out.println(person);*/

        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        TestService testService = (TestService) applicationContext.getBean("testService");
        System.out.println(testService);*/

        /*AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        TestService testService = (TestService) annotationConfigApplicationContext.getBean("testService");
        System.out.println(testService);*/

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name:beanNames) {
            System.out.println(name);
        }


    }
}
