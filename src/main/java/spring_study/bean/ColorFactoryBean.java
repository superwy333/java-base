package spring_study.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 工厂Bean，用来创建Color对象
 */
public class ColorFactoryBean implements FactoryBean<Color> {

    @Override
    public Color getObject() throws Exception {
        System.out.println("创建Color对象");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 是否单例
     * @return true：单实例 false：多实例
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
