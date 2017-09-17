package edu.tongji.comm.design.pattern.singleton;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description
 */
public class LazySingletonWithSynchronized {

    private static LazySingletonWithSynchronized instance = null;

    private LazySingletonWithSynchronized() {

    }

    //高并发下效率太低，每次去获取实例，均会锁住整个对象
    synchronized public static LazySingletonWithSynchronized getInstance1() {
        if (instance == null) {
            instance = new LazySingletonWithSynchronized();
        }
        return instance;
    }

    //高并发下还是会出现多个实例，因为变量缺少可见性
    //假如在某一瞬间线程A和线程B都在调用getInstance()方法，此时instance对象为null值，均能通过instance == null的判断。
    //由于实现了synchronized加锁机制，线程A进入synchronized锁定的代码中执行实例创建代码，
    //线程B处于排队等待状态，必须等待线程A执行完毕后才可以进入synchronized锁定代码。
    //但当A执行完毕时，线程B并不知道实例已经创建，将继续创建新的实例，导致产生多个单例对象，
    public static LazySingletonWithSynchronized getInstance2() {
        if (instance == null) {
            synchronized (LazySingletonWithSynchronized.class) {
                instance = new LazySingletonWithSynchronized();
            }
        }
        return instance;
    }

}
