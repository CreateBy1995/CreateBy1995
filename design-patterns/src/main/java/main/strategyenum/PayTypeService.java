package main.strategyenum;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2020-12-14
 **/
@Slf4j
public class PayTypeService {
    public void payWithWeChat(){
        log.info("使用微信支付,支付金额20元");
    }

    public void payWithAli(){
        log.info("使用支付宝支付,支付金额20元");
    }
}
