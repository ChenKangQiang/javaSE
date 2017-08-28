package edu.tongji.comm.design.pattern.singleton;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description
 */

/**
 * 饿汉式单例
 */
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();
    private EagerSingleton() {

    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
