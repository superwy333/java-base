package spring_study.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import spring_study.bean.Car;
import spring_study.bean.Cat;

/**
 * bean的生命周期：bean创建---初始化---销毁
 * 容器管理bean的生命周期
 * 可以自定义bean的初始化和销毁方法；容器在进行到对于bean的生命周期的时候会调用自定义的初始化和销毁方法
 * 对象创建构造器：
 *                  单实例：IOC容器启动时执行
 *                  多实例：每次从IOC容器获取对象时执行
 * 四种方式自定义初始化和销毁方法：
 * 1.在xml配置文件中指定初始化和销毁方法<bean id="person" class="spring_study.bean.Person" init-method="" destroy-method="">
 *     这两个方法必须没有参数，可以抛出异常
 * 2.通过@Bean注解指定初始化和销毁方法；初始化方法在构造器之后调用，销毁方法在容器关闭时调用
 * 3.Bean实现InitializingBean接口定义初始化逻辑；实现DisposableBean接口定义销毁方法
 * 4.使用JSR250规范中定义的两个注解
 *                             @PostConstruct在Bean创建完成，并且属性赋值完成时执行初始化方法
 *                             @PreDestroy在Bean将要被一处之前执行
 * BeanPostProcessor:bean的后置处理器，在初始化方法调用前后执行
 *                             初始化方法调用之前执行 Object postProcessBeforeInitialization(Object var1, String var2) throws BeansException;
 *                             初始化方法调用之后执行 Object postProcessAfterInitialization(Object var1, String var2) throws BeansException;
 *
 *
 */

@Configuration
@ComponentScan("spring_study")
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init", destroyMethod = "destory")
    @Scope("prototype")
    public Car car() {
        return new Car();
    }

    @Bean
    @Scope("prototype")
    public Cat cat() {
        return new Cat();
    }


}
