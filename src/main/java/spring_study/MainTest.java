package spring_study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import spring_study.bean.Color;
import spring_study.bean.ColorFactoryBean;
import spring_study.bean.Person;
import spring_study.config.MainConfig;
import spring_study.config.MainConfig2;
import spring_study.service.TestService;

import java.util.Map;

/**
 * Created by wangyang on 2019/3/10.
 */
public class MainTest {

    @Autowired  Person bill;
    @Autowired  Person lix;

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

        // 读取配置类，创建IOC容器；并且创建所有单例的非懒加载的bean
        /*AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println("IOC容器创建完成");
        String[] beanNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name:beanNames) {
            System.out.println(name);
        }*/

        // IOC容器中默认的bean都是单例的，所以下面获取的三个bean的内存地址都是一样的
        /*Person p1 = (Person) annotationConfigApplicationContext.getBean("person");
        Person p2 = (Person) annotationConfigApplicationContext.getBean("person");
        Person p3 = (Person) annotationConfigApplicationContext.getBean("person");
        System.out.println("p1 address: " + p1);
        System.out.println("p1 address: " + p2);
        System.out.println("p1 address: " + p3);
        System.out.println(p1==p2);
        System.out.println(p3==p2);*/

        /*AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println("IOC容器创建完成");
        String[] beanNames = annotationConfigApplicationContext.getBeanNamesForType(Person.class); // 找到IOC容器中所有类型是Person的对象名字
        for (String name:beanNames) {
            System.out.println(name);
        }
        Map<String,Person> persons =  annotationConfigApplicationContext.getBeansOfType(Person.class); // 找到IOC中所有类型是Person的对象，返回值是一个map，key是对象名字，value是对象
        System.out.println(persons);

        // 从IOC容器中获取操作系统名称
        ConfigurableEnvironment env =  annotationConfigApplicationContext.getEnvironment();
        String osName = env.getProperty("os.name");
        System.out.println(osName);*/

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println("IOC容器创建完成");
        String[] beanNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name:beanNames) {
            System.out.println(name);
        }
        // 这边获取的是Color对象！
        Color color1 = (Color) annotationConfigApplicationContext.getBean("colorFactoryBean");
        Color color2 = (Color) annotationConfigApplicationContext.getBean("colorFactoryBean");
        Color color3 = (Color) annotationConfigApplicationContext.getBean("colorFactoryBean");
        System.out.println(color1);
        System.out.println(color2);
        System.out.println(color3);

        Object bean = annotationConfigApplicationContext.getBean("&colorFactoryBean");
        System.out.println(bean); // spring_study.bean.ColorFactoryBean@2cd2a21f

    }

}
