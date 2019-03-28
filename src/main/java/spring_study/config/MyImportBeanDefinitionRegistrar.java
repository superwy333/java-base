package spring_study.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import spring_study.bean.RainBow;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     *
     * @param annotationMetadata 当前类的注解信息
     * @param beanDefinitionRegistry Bean注册器
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        boolean definition = beanDefinitionRegistry.containsBeanDefinition("spring_study.bean.Red");
        boolean definition2 = beanDefinitionRegistry.containsBeanDefinition("spring_study.bean.Blue");
        RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
        /**
         * 向IOC容器中注册bean
         * 如果容器中有spring_study.bean.Red和spring_study.bean.Blue则向容器中注册RainBow对象
         * 第一个参数是bean在容器中的id
         * 第二个参数是一个BeanDefinition对象，用于指定bean的包路径和scope等信息
         */
        if (definition && definition2) beanDefinitionRegistry.registerBeanDefinition("RainBow111", beanDefinition);
    }
}
