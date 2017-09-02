package edu.tongji.comm.design.pattern.observer;

import edu.tongji.comm.design.pattern.observer.api.DisplayElement;
import edu.tongji.comm.design.pattern.observer.api.Observer;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description
 */
public class CurrentConditionDisplay implements DisplayElement, Observer {

    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void display() {
        System.out.println("temperature=" + temperature + "; humidity=" + humidity + "; pressure=" + pressure);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        /**
         * 一些具体实现
         */
        this.display();
    }


}
