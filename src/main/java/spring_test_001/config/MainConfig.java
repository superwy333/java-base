package spring_test_001.config;


import cn.hutool.setting.Setting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import spring_test_001.processor.Processor;
import spring_test_001.processor.UserProcessorForProjectA;
import spring_test_001.processor.UserProcessorForProjectB;


@Configuration
@ComponentScan(value = "spring_test_001", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
},useDefaultFilters = false)
public class MainConfig {

    @Bean("processor")
    public Processor processor1() {

        String projectId = new Setting("spring_test_001/config.properties").get("projectId");
        switch (projectId) {
            case "prokectA": return new UserProcessorForProjectA(projectId);
            case "prokectB": return new UserProcessorForProjectB(projectId);
        }
        return null;
    }



}
