package spring_study.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import spring_study.bean.Color;
import spring_study.bean.ColorFactoryBean;
import spring_study.bean.Person;
import spring_study.bean.Red;
import spring_study.conditions.LinuxCondition;
import spring_study.conditions.WindowsCondition;

import java.security.PublicKey;

/**
 * Created by wangyang on 2019/3/10.
 */

@Configuration // 表示这是一个配置类
//@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class}) // 直接在配置类上使用@Import注解注册组建
public class MainConfig2 {

    @Lazy
    @Bean(value = "person") // 默认单例的bean
    //@Scope(value = "prototype") // 指定@Scope使其变为多实例
    public Person person() {
        System.out.println("向IOC容器中添加person");
        return new Person(25,"zhangsan");
    }

    /**
     * @Conditional注解：按照条件向IOC容器中注册bean
     * 条件：如果是windows系统，则向容器中注册bill；如果是linux系统，则向容器注册lix
     *
     * @return
     */
    @Conditional({LinuxCondition.class})
    @Bean(value = "lix")
    public Person person01() {
        System.out.println("lix创建...");
        return new Person(38, "Lix");
    }

    @Conditional({WindowsCondition.class})
    @Bean(value = "bill")
    public Person person02() {
        System.out.println("bill创建...");
        return new Person(25, "Bill");
    }

    /**
     * 向容器中注册ColorFactoryBean
     * @return Color对象！！！即工厂bean调用getObject()方法调用的对象
     */
    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }

}
