package spring_study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_study.config.MainConfigOfLifeCycle;

public class MainTestOfLifeCycle {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("IOC容器创建完成");
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String name:beanNames) {
            System.out.println(name);
        }
        Object bean = applicationContext.getBean("car");
        Object bean2 = applicationContext.getBean("cat");

        applicationContext.close(); // 关闭容器，调用容器中所有bean的销毁方法
    }
}
