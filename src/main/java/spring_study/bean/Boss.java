package spring_study.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 默认把组件注册到容器中去，容器启动时会调用这个类的无参构造器进行创建对象
public class Boss {

    //@Autowired // 直接使用容器中的car为Boss自动装配
    private Car car;

    public Car getCar() {
        return car;
    }

    // 直接标注在方法上，spring执行方法的时候也会进行自动装配
    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }
}
