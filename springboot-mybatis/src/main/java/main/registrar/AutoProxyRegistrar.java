package main.registrar;

import main.annotations.AutoProxy;
import main.annotations.EnableAutoProxy;
import main.factorybeans.CustomFactoryBean;
import main.scanners.CustomizeClassPathMapperScanner;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2020-12-11
 **/
public class AutoProxyRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(EnableAutoProxy.class.getName()));
        CustomizeClassPathMapperScanner scanner = new CustomizeClassPathMapperScanner(registry);
        // 注册过滤器
        scanner.registerFilters(AutoProxy.class.getName());
        // 扫描路径
        String[] basePackages = attributes.getStringArray("value");
        // 执行类扫描
        Set<BeanDefinitionHolder> beanDefinitionHolders = scanner.doScan(basePackages);
        // 修改默认的Bean定义 统一由FactoryBean去创建实例
        beanDefinitionHolders.forEach(beanDefinitionHolder -> {
            ScannedGenericBeanDefinition beanDefinition = (ScannedGenericBeanDefinition) beanDefinitionHolder.getBeanDefinition();
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
            beanDefinition.setBeanClass(CustomFactoryBean.class);
        });
    }
}
