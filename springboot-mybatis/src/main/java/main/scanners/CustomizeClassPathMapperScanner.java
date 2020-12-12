package main.scanners;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * @Author: dongcx
 * @Description: 自定义扫描器
 * @Date: 2020-12-11
 **/
public class CustomizeClassPathMapperScanner extends ClassPathBeanDefinitionScanner {

    public CustomizeClassPathMapperScanner(BeanDefinitionRegistry registry) {
        super(registry, false);
    }

    /**
     * 过滤出带有指定注解的类
     */
    public void registerFilters(String annotationName) {
        addIncludeFilter((metadataReader, metadataReaderFactory) ->
                metadataReader.getAnnotationMetadata().isAnnotated(annotationName));
    }

    /**
     * 候选类必须是个接口
     *
     * @param beanDefinition
     * @return
     */
    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface() && !beanDefinition.getMetadata().isAnnotation();
    }

    public Set<BeanDefinitionHolder> doScan(String... basePackages) {
        return super.doScan(basePackages);
    }
}
