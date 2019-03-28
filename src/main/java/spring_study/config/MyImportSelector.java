package spring_study.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import spring_study.bean.Blue;

/**
 * 自定义逻辑，返回需要注册的组建全路径
 */
public class MyImportSelector implements ImportSelector {

    /**
     *
     * @param annotationMetadata 当前标注@Import注解类的信息
     * @return 返回值就是要注册的组件类全类名
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"spring_study.bean.Blue"};
    }
}
