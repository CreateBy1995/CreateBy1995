package main.observer;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: dongcx
 * @Description: 具体观察者
 * @Date: 2020-12-16
 **/
@Slf4j
public class BossListener implements Listener {
    /**
     * 实现handleEvent方法，作为处理各种事件的入口
     * 此处可以修改为策略模式+工厂模式来消除if else
     *
     * @param event
     */
    @Override
    public void handleEvent(Event event) {
        if (event instanceof ToWorkEvent) {
            toWork(event);
        } else {
            log.info("BossListener ignore event:{}", event.getClass());
        }

    }

    public void toWork(Event event) {
        log.info("BossListener go to work, time : {}", event.getEventTime());
    }
}
