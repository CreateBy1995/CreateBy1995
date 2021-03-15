package main.wrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: dongcx
 * @Description: 具体目标类
 * @Date: 2020-12-17
 **/
@Slf4j
public class OriginalSender implements Sender {
    @Override
    public void send(){
        log.info("send message");
    }
}
