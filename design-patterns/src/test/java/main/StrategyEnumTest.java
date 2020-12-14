package main;

import main.strategyenum.Customer;
import main.strategyenum.PayEnum;
import org.junit.Test;

/**
 * @Author: dongcx
 * @Description: 使用枚举策略代替策略模式+工厂模式
 * 这样的好处是不需要每多加一种策略就要多加一个类
 * @Date: 2020-12-14
 **/
public class StrategyEnumTest {
    @Test
    public void test0001(){
        Customer customer = new Customer(PayEnum.getPayEnum("ali"));
        customer.buy();
    }

    @Test
    public void test0002(){
        Customer customer = new Customer(PayEnum.getPayEnum("weChat"));
        customer.buy();
    }
}
