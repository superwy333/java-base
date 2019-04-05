package spring_study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import spring_study.bean.Person;

/**
 * Created by wangyang on 2019/4/4.
 */



@PropertySource(value = {"classpath:/person.properties"}, encoding="UTF-8") // 加载外部配置文件，保存到运行时环境变量中
@Configuration
public class MainConfigOfPropertyValue {



    @Bean
    public Person person() {
        return new Person();
    }



}
