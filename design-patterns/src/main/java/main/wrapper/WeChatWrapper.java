package main.wrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: dongcx
 * @Description: 具体装饰类
 * @Date: 2020-12-17
 **/
@Slf4j
public class WeChatWrapper implements Wrapper {
    private Sender sender;
    public WeChatWrapper(Sender sender) {
        this.sender = sender;
    }

    @Override
    public void send() {
        sender.send();
        weChatSend();
    }

    private void weChatSend() {
        log.info("send to weChat");
    }
}
