package main.observer;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: dongcx
 * @Description: 下班事件
 * @Date: 2020-12-16
 **/
@Data
@AllArgsConstructor
public class OffWorkEvent implements Event {
    private long timeStamp;

    @Override
    public long getEventTime() {
        return getTimeStamp();
    }
}
