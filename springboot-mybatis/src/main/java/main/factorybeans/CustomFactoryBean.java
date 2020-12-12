package main.factorybeans;

import lombok.extern.slf4j.Slf4j;
import main.utils.ProxyUtil;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: dongcx
 * @Description: 用于生成代理类
 * @Date: 2020-12-11
 **/
@Slf4j
public class CustomFactoryBean<T> implements FactoryBean<T> {
    private Class<T> interfaceType;

    public CustomFactoryBean(Class<T> interfaceType) {
        this.interfaceType = interfaceType;
    }

    @Override
    public T getObject() {
        return ProxyUtil.getProxy(interfaceType);
    }

    @Override
    public Class<T> getObjectType() {
        return interfaceType;
    }


}
