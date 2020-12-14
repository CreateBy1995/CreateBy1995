package main.strategyenum;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: dongcx
 * @Description: 支付方式枚举
 * @Date: 2020-12-14
 **/
@Slf4j
@AllArgsConstructor
public enum PayEnum {
    ALI_PAY("ali") {
        @Override
        public void pay() {
            log.info("使用支付宝支付,支付金额20元");
        }
    },
    WE_CHAT_PAY("weChat") {
        @Override
        public void pay() {
            log.info("使用微信支付,支付金额20元");
        }
    };
    private String payType;

    /**
     * 支付方法
     */
    public void pay() {
        throw new NoPayTypeException();
    }

    private static Map<String, PayEnum> payEnumMap;

    /**
     * 初始化所有支付策略
     * 作用等同于一个工厂类
     */
    static {
        payEnumMap = new HashMap<>();
        for (PayEnum payEnum : PayEnum.values()) {
            payEnumMap.put(payEnum.payType, payEnum);
        }
    }

    public static PayEnum getPayEnum(String payType) {
        return payEnumMap.get(payType);
    }
}
