package spring_study.bean;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog {

    public Dog() {
        System.out.println("创建Dog...");
    }


    @PostConstruct
    public void postConstruct() {
        System.out.println("Dog init...");
    }

    @PreDestroy
    public void PreDestroy() {
        System.out.println("Dog destroy...");
    }

}
