package spring_study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import spring_study.bean.Person;
import spring_study.config.MainConfigOfLifeCycle;
import spring_study.config.MainConfigOfPropertyValue;

/**
 * Created by wangyang on 2019/4/4.
 */
public class MainTestOfPropertyValue {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
        System.out.println("IOC容器创建完成");
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String name:beanNames) {
            System.out.println(name);
        }

        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        Environment env = applicationContext.getEnvironment();
        String nickName = env.getProperty("person.nickName");
        System.out.println("nickName: " + nickName );

        applicationContext.close();


    }
}
