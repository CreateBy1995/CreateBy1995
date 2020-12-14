package main.strategyenum;

import org.springframework.util.Assert;

/**
 * @Author: dongcx
 * @Description: 用于保存策略的上下文, 此处之所以需要用一个上下文类来调用具体的策略方法，
 * 而不去直接调用具体的策略，是因为如果说需要保存一些上下文状态，那么直接加到策略实现中不太合适
 * 所以需要用给一个上下文对象来保存 例如此处需要保存一个专门用于支付业务的Service
 * @Date: 2020-12-14
 **/
public class Customer {

    public Customer(PayEnum payEnum) {
        Assert.notNull(payEnum, "支付方式不能为空");
        this.payEnum = payEnum;
        this.payTypeService = new PayTypeService();
    }

    private PayEnum payEnum;
    private PayTypeService payTypeService;

    public void buy() {
        payEnum.pay(payTypeService);
    }
}
