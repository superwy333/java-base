package spring_study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import spring_study.bean.Person;

/**
 * Created by wangyang on 2019/3/10.
 */

@Configuration // 表示这是一个配置类
@ComponentScan(value = "spring_study", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
},useDefaultFilters = false) // 使用includeFilters配置只包含的时候，必须加上useDefaultFilters = false使得默认全部包含的规则失效
public class MainConfig {

    @Bean(value = "ppp") // 默认以方法名作为Bean在IOC容器中的ID，也可以在@Bean注解上设置value来设置名称
    public Person person() {
        return new Person(20,"lisi");
    }

}
