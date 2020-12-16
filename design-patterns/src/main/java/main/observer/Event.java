package main.observer;

/**
 * @Author: dongcx
 * @Description: 把通知变成一个Event对象，从而是Listener接口中不再需要有多种方法通知
 * 而是只需要一个入口方法，在入口方法中，各个观察者的实现类再去对事件做判断
 * @Date: 2020-12-16
 **/
public interface Event {
    /**
     * 获取事件发生的时间
     * @return
     */
    long getEventTime();
}
