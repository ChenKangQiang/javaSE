package edu.tongji.comm.design.pattern.observer.api;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
