package main.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: dongcx
 * @Description: 广播器，用于发布事件通知观察者
 * @Date: 2020-12-16
 **/
public class Multicaster {
    private List<Listener> listeners = new ArrayList<>();

    /**
     * 发布事件，通知各个观察者
     *
     * @param event
     */
    public void onPublish(Event event) {
        listeners.forEach(listener -> listener.handleEvent(event));
    }

    /**
     * 添加观察者
     *
     * @param listener
     * @return
     */
    public boolean addListener(Listener listener) {
        Objects.requireNonNull(listener);
        return listeners.add(listener);

    }

    public boolean addListener(List<Listener> listener) {
        Objects.requireNonNull(listener);
        return listeners.addAll(listener);
    }
}
