package spring_study.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Cat implements InitializingBean, DisposableBean {


    public Cat() {
        System.out.println("创建cat...");
    }

    /**
     * 销毁方法，支队单实例有效
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("cat destory...");

    }

    /**
     * 初始化方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat init...");

    }
}
