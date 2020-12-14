package main.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: dongcx
 * @Description: 具体策略实现
 * @Date: 2020-12-14
 **/
@Slf4j
public class WeChatPayServiceImpl implements PayService {
    private final static String PAY_TYPE = "ali";

    @Override
    public void pay() {
        log.info("使用微信支付,支付金额20元");
    }

    @Override
    public String getPayType() {
        return PAY_TYPE;
    }
}
