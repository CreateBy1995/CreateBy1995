package main.strategy;

import org.springframework.util.Assert;

/**
 * @Author: dongcx
 * @Description: 用于保存策略的上下文, 此处之所以需要用一个上下文类来调用具体的策略方法，
 * 而不去直接调用具体的策略，是因为如果说需要保存一些上下文状态，那么直接加到策略实现中不太合适
 * 所以需要用给一个上下文对象来保存
 * @Date: 2020-12-14
 **/
public class Customer {
    public Customer(PayService payService) {
        Assert.notNull(payService, "支付方式不能为空");
        this.payService = payService;
    }

    private PayService payService;

    public void buy() {
        payService.pay();
    }
}
