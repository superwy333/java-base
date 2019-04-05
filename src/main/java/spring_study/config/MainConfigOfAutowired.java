package spring_study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配：spring利用依赖注入(DI)，完成对IOC容器中各个组件的依赖关系赋值
 * @Autowired
 * Created by wangyang on 2019/4/4.
 */

@Configuration
@ComponentScan("spring_study") // 使用包扫描的方式向IOC容器中注入bean,扫描的时候如果有configuration，那么扫描进来的configuration也会生效
public class MainConfigOfAutowired {





}
