package spring_study.bean;

import org.springframework.stereotype.Component;

@Component
public class Car {


    public Car() {
        System.out.println("创建Car...");
    }

    public void init() {
        System.out.println("car init...");
    }

    public void destory() {
        System.out.println("car destory...");
    }
}


