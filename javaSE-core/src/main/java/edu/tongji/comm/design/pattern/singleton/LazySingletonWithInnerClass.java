package edu.tongji.comm.design.pattern.singleton;

/**
 * @author chenkangqiang
 * @date 2017/8/29
 * @Description
 */

/**
 * 使用静态内部类来实现延迟加载，同时解决同步问题
 */
public class LazySingletonWithInnerClass {

    private LazySingletonWithInnerClass() {

    }

    private static class HolderClass {
        private final static LazySingletonWithInnerClass instance = new LazySingletonWithInnerClass();
    }

    public static LazySingletonWithInnerClass getInstance() {
        return HolderClass.instance;
    }


}
