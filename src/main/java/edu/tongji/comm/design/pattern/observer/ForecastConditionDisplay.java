package edu.tongji.comm.design.pattern.observer;

import edu.tongji.comm.design.pattern.observer.api.DisplayElement;
import edu.tongji.comm.design.pattern.observer.api.Observer;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description
 */
public class ForecastConditionDisplay implements DisplayElement, Observer {

    @Override
    public void display() {

    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        /**
         * 具体实现
         */
    }
}
