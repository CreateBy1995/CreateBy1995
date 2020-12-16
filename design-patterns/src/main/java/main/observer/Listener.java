package main.observer;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2020-12-16
 **/
public interface Listener {
    /**
     * 观察者需要实现这个方法，作为处理各种事件的入口
     * @param event
     */
    void handleEvent(Event event);
}
