package edu.tongji.comm.design.pattern.singleton;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description
 */
public class SingletonThread<T> implements Runnable {

    private T object;

    @Override
    public void run() {
        object = (T)LazySingletonWithSynchronized.getInstance1();
    }


    public T getLoadBalancer() {
        return object;
    }
}
