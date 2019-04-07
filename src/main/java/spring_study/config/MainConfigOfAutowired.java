package spring_study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import spring_study.dao.TestDao;

/**
 * 自动装配：spring利用依赖注入(DI)，完成对IOC容器中各个组件的依赖关系赋值
 * @Autowired 自动注入 spring的注解
 *                  1.默认优先按照类型去IOC容器中获取：applicationContext.getBean(TestDao.class);
 *                  2.如果找到多个相同类型的组件，再将属性名作为ID去容器中查找：applicationContext.getBean("testDao")
 *                  3.使用@Qualifier("testDao")明确指定需要装配的组建id，而不是使用属性名作为id
 *                  4.默认情况下自动装配一定要将组件在容器中注入好，容器中没有组件则自动装配会报错
 *                  5.可以使用@Autowired(required = false)来调整组件再容器中不存在的时候不报错
 *                  6.当容器中有相同类型，相同id的组件时，可以使用@Primary来指定优先使用哪个组件，使用@Primary之后就不能使用@Qualifier("testDao"),@Primary是无视名字的
 *
 * @Resource JAVA规范的注解 JSR250
 *                  1.可以和@Autowired一样实现自动装配功能
 *                  2.默认按照组件id来进行自动装配
 *                  3.使用@Resource(name = "testDao2")指定组件id
 *                  4.没有支持@Primary和@Autowired(required = false)的功能
 *
 * @Inject JAVA规范的注解 JSR330
 *                  1.需要导入javax.inject包
 *                  2.和@Autowired功能基本一致
 *                  3.缺失@Autowired(required = false)的功能
 *
 * @Autowired注释的位置：属性、构造器、方法、参数
 *                  1.方法上
 * Created by wangyang on 2019/4/4.
 */

@Configuration
@ComponentScan("spring_study.bean") // 使用包扫描的方式向IOC容器中注入bean,扫描的时候如果有configuration，那么扫描进来的configuration也会生效
public class MainConfigOfAutowired {

    @Primary
    @Bean("testDao2")
    public TestDao testDao() {
        TestDao testDao = new TestDao();
        testDao.setLable("2");
        return testDao;
    }
}
