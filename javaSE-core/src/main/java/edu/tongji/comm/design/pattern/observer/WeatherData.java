package edu.tongji.comm.design.pattern.observer;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description
 */

import com.google.common.collect.Lists;
import edu.tongji.comm.design.pattern.observer.api.Observer;
import edu.tongji.comm.design.pattern.observer.api.Subject;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 被观察者
 */

@Data
@Component
public class WeatherData implements Subject {

    //一系列观察者
    private List<Observer> observers = Lists.newArrayList();
    private float temperature;
    private float humidity;
    private float pressure;
    /**
     * 状态改变标志
     */
    private boolean changed = false;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (CollectionUtils.isNotEmpty(observers) && observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        if (changed) {
            for (Observer observer : observers) {
                observer.update(temperature, humidity, pressure);
            }
        }
        setChanged(false);
    }

}
