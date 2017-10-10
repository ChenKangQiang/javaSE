package edu.tongji.comm.example.multithread.singletonperthreadV2;

/**
 * @Author chenkangqiang
 * @Data 2017/10/10
 *
 * 每个Thread拥有一个单例工厂
 */
public class ThreadLocalFactory<T> implements Factory<T> {

    private final ThreadLocal<T> threadLocal;

    public ThreadLocalFactory(final Factory<T> factory) {
        threadLocal = new ThreadLocal<T>() {
            @Override
            protected T initialValue() {
                return factory.create();
            }
        };
    }

    @Override
    public T create() {
        return threadLocal.get();
    }


}
