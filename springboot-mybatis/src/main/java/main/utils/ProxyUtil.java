package main.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2020-12-11
 **/
@Slf4j
public class ProxyUtil {
    public static <T> T getProxy(Class<T> interfaceType) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(interfaceType);
        enhancer.setCallback((MethodInterceptor) (object, method, objects, methodProxy) -> {
            log.info("proxy object invoke method:{}", method.getName());
            return object;
        });
        return (T) enhancer.create();
    }
}
