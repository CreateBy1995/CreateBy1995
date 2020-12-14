package main.strategyenum;

/**
 * @Author: dongcx
 * @Description: 自定义异常
 * @Date: 2020-12-14
 **/
public class NoPayTypeException extends RuntimeException {
    public NoPayTypeException() {
        super("支付方式不能为空");
    }
}
