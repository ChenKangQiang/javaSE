package edu.tongji.comm.design.pattern.singleton;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description
 */

/**
 * 懒汉式双重锁
 */
public class LazySingletonWithTwoCheck {

    //volatile用于保证可见性，如果没有volatile，则第二重判断会不准确，还是会出现多个实例
    private volatile static LazySingletonWithTwoCheck instance = null;

    private LazySingletonWithTwoCheck() { }

    public static LazySingletonWithTwoCheck getInstance() {
        //第一重判断
        if (instance == null) {
            //锁定代码块
            synchronized (LazySingletonWithTwoCheck.class) {
                //第二重判断
                if (instance == null) {
                    instance = new LazySingletonWithTwoCheck(); //创建单例实例
                }
            }
        }
        return instance;
    }

}
