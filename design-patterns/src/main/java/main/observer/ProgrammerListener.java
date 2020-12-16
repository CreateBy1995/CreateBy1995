package main.observer;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: dongcx
 * @Description: 具体观察者
 * @Date: 2020-12-16
 **/
@Slf4j
public class ProgrammerListener implements Listener {
    /**
     * 实现handleEvent方法，作为处理各种事件的入口
     * 此处可以修改为策略模式+工厂模式来消除if else
     * @param event
     */
    @Override
    public void handleEvent(Event event) {
        if (event instanceof OffWorkEvent) {
            offWork(event);
        } else if (event instanceof ToWorkEvent) {
            toWork(event);
        } else {
            log.info("ProgrammerListener ignore event:{}", event.getClass());
        }

    }

    public void offWork(Event event) {
        log.info("ProgrammerListener go home, time : {}", event.getEventTime());
    }

    public void toWork(Event event) {
        log.info("ProgrammerListener go to work, time : {}", event.getEventTime());
    }
}
