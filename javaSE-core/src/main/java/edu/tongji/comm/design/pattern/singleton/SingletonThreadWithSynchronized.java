package edu.tongji.comm.design.pattern.singleton;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description
 */
public class SingletonThreadWithSynchronized implements Runnable {

    private LazySingletonWithSynchronized singleton;

    @Override
    public void run() {
        singleton = LazySingletonWithSynchronized.getInstance2();
    }


    public LazySingletonWithSynchronized getLoadBalancer() {
        return singleton;
    }
}
