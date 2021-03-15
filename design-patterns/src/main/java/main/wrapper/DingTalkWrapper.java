package main.wrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: dongcx
 * @Description: 具体装饰类
 * @Date: 2020-12-17
 **/
@Slf4j
public class DingTalkWrapper implements Wrapper {
    private Sender sender;

    public DingTalkWrapper(Sender sender) {
        this.sender = sender;
    }

    @Override
    public void send() {
        sender.send();
        dingTalkSend();
    }

    private void dingTalkSend() {
        log.info("send to DingDing");
    }
}
