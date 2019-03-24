package spring_study.conditions;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {
    /**
     * @param conditionContext 判断条件能使用的上下文环境
     * @param annotatedTypeMetadata 注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory(); // 获取IOC创建bean的工厂
        ClassLoader classLoader = conditionContext.getClassLoader(); // 获取类加载器
        BeanDefinitionRegistry beanDefinitionRegistry = conditionContext.getRegistry(); // 获取bean定义的注册类，可以判断容器中bean的注册情况，也可以向容器中注册bean
        Environment env = conditionContext.getEnvironment(); // 获取运行时环境

        String osName = env.getProperty("os.name");
        System.out.println(osName);
        if (osName.contains("Windows")) return false;
        if (osName.contains("Linux")) return true;
        return false;
    }
}
