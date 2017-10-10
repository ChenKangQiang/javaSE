package edu.tongji.comm.example.multithread.singletonperthread;

/**
 * @Author chenkangqiang
 * @Data 2017/10/10
 *
 *
 * 使用threadlocal为每个线程创建一个单例
 */
public class Singleton {

    private Singleton() {

    }

    /**
     * 覆盖匿名类的initialValue方法，
     * 该方法是一个延迟调用方法，在线程第1次调用get()或set(Object)时才执行，并且仅执行1次
     */
    private static ThreadLocal<Singleton> threadLocal =
            new ThreadLocal<Singleton>() {
                @Override
                protected Singleton initialValue() {
                    return new Singleton();
                }
            };

    /**
     * java8的话，可以使用withInitial()和lambda表达式
     */
    private static ThreadLocal<Singleton> threadLocallambda = ThreadLocal.withInitial(() -> new Singleton());

    /**
     * Returns the thread local singleton instance
     *
     * @return
     */
    public static Singleton getInstance() {
        return threadLocal.get();
    }



}
