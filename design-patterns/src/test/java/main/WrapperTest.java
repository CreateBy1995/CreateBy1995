package main;

import main.wrapper.DingTalkWrapper;
import main.wrapper.OriginalSender;
import main.wrapper.Sender;
import main.wrapper.WeChatWrapper;
import org.junit.Test;

/**
 * @Author: dongcx
 * @Description: 装饰器模式主要目的是增强目标类的功能，例如原先的类A实现了一个发送消息的功能
 * 但是现在又需要在发送之前做一些处理(新功能)，使用装饰器模式能在不改动原先目标类代码的情况下，去完成需要新增的功能
 * 并且装饰器是属于可拔插的，如果某天不需要这些功能了，不需要再去还原目标类的代码
 * JDK中的IO流就是典型的装饰器模式
 * 目标接口
 * @see java.io.InputStream
 * 具体目标类
 * @see java.io.FileInputStream
 * 具体装饰器
 * @see java.io.BufferedInputStream
 * @Date: 2020-12-17
 **/
public class WrapperTest {
    @Test
    public void test0001(){
        // 原始目标类
        Sender originalSender = new OriginalSender();
        // 具体装饰类
        Sender weChatWrapper = new WeChatWrapper(originalSender);
        // 具体装饰类
        Sender dingTalkWrapper = new DingTalkWrapper(weChatWrapper);
        dingTalkWrapper.send();
    }

}
