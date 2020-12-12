package main.annotations;

import main.registrar.AutoProxyRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: dongcx
 * @Description: 开启自动代理
 * @Date: 2020-12-11
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(AutoProxyRegistrar.class)
public @interface EnableAutoProxy {
    String[] value() default {};
}
