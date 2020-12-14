package main.strategy;

/**
 * @Author: dongcx
 * @Description: 策略模式接口
 * @Date: 2020-12-14
 **/
public interface PayService {
    void pay();
    String getPayType();
}
