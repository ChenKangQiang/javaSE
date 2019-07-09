package edu.tongji.comm.design.pattern.observer.api;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description 观察者，会根据当前的天气状况实时改变
 */
public interface Observer {
    void update(float temp, float humidity, float pressure);
}
