package main;

import main.observer.BossListener;
import main.observer.Event;
import main.observer.Listener;
import main.observer.Multicaster;
import main.observer.OffWorkEvent;
import main.observer.ProgrammerListener;
import main.observer.ToWorkEvent;
import org.junit.Test;

/**
 * @Author: dongcx
 * @Description: 观察者模式中的各个组件可以对应参考Spring中的代码
 * 事件Event
 * @see org.springframework.context.ApplicationEvent
 * 广播器 Multicaster
 * @see org.springframework.context.event.ApplicationEventMulticaster
 * 观察者Listener
 * @see org.springframework.context.ApplicationListener
 * @Date: 2020-12-16
 **/
public class ObserverTest {
    @Test
    public void test0001(){
        // 事件广播器  用于发布事件通知观察者
        Multicaster multicaster = new Multicaster();
        // 具体观察者 整合Spring后可以通过Spring提供的后置处理接口将自身加入到广播器中
        Listener programmerListener = new ProgrammerListener();
        Listener bossListener = new BossListener();
        // 添加观察者
        multicaster.addListener(programmerListener);
        multicaster.addListener(bossListener);
        // 定义事件
        Event offWordEvent = new OffWorkEvent(System.currentTimeMillis());
        Event toWordEvent = new ToWorkEvent(System.currentTimeMillis());
        // 发布事件
        multicaster.onPublish(offWordEvent);
        multicaster.onPublish(toWordEvent);
    }
}
