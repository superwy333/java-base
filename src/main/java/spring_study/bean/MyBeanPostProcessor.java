package spring_study.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 后置处理器，初始化前后执行方法
 */
@Component // 将后置处理器加入到容器中
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     *
     * @param o 容器刚创建的实例
     * @param s 实例在容器中创建的id
     * @return 容器中的实例，可以返回原来的对象，也能把原来的对象包装好之后返回
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization...>>>" + s + " " + o);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization...>>>" + s + " " + o);
        return o;
    }
}
