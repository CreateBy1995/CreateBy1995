package main;

import lombok.extern.slf4j.Slf4j;
import main.strategy.AliPayServiceImpl;
import main.strategy.Customer;
import main.strategy.PayService;
import main.strategy.PayServiceFactory;
import main.strategy.WeChatPayServiceImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: dongcx
 * @Description: 使用工厂模式加上策略模式，消除代码中的if-else
 * 此模式可以进一步优化成枚举策略
 * @Date: 2020-12-14
 **/
@Slf4j
public class StrategyTest {
    @Before
    public void before() {
        // 在方法执行前注册具体的策略,如果整合spring后，可以根据spring提供的后置处理接口
        // 在Bean初始化完毕后将Bean注册到工厂中
        PayService aliPayServiceImpl = new AliPayServiceImpl();
        PayService weChatPayServiceImpl = new WeChatPayServiceImpl();
        PayServiceFactory.registerPayService(aliPayServiceImpl);
        PayServiceFactory.registerPayService(weChatPayServiceImpl);
    }

    @Test
    public void test0001() {
        Customer customer = new Customer(PayServiceFactory.getPayService("ali"));
        customer.buy();
    }

    @Test
    public void test0002() {
        Customer customer = new Customer(PayServiceFactory.getPayService("weChat"));
        customer.buy();
    }

    @Test
    public void test0003() {
        Customer customer = new Customer(PayServiceFactory.getPayService("jd"));
        customer.buy();
    }
}
