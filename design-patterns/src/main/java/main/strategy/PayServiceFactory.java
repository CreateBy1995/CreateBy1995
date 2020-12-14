package main.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: dongcx
 * @Description: 具体策略生成工厂
 * @Date: 2020-12-14
 **/
public class PayServiceFactory {
    /**
     * 支付策略注册表
     */
    private static Map<String, PayService> payServiceMap = new HashMap<>();

    /**
     * 根据支付方式获取具体的策略
     *
     * @param payType 支付方式
     * @return
     */
    public static PayService getPayService(String payType) {
        return payServiceMap.get(payType);
    }

    /**
     * 将具体的策略实现注册到工厂
     *
     * @param payService 具体策略
     */
    public static void registerPayService(PayService payService) {
        payServiceMap.put(payService.getPayType(), payService);
    }

}
