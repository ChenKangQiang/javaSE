package edu.tongji.comm.example.classloaddemo;

import java.util.Random;

/**
 * @Author chenkangqiang
 * @Data 2017/9/17
 *
 * 演示类的静态变量、普通变量、静态内部类、普通内部类的加载顺序
 *
 */
public class OuterClass {

    public static final long OUTER_TIME = System.currentTimeMillis();

    public static void sayHello() {
        System.out.println("直接调用静态方法，虚拟机会首先加载类的静态属性");
        System.out.println(OUTER_TIME);
    }

    static {
        System.out.println("外部类静态块加载时间=" + System.currentTimeMillis());
    }

    public OuterClass() {
        timeElapsed();
        System.out.println("外部类构造函数时间=" + System.currentTimeMillis());
    }

    static class InnerStaticClass {
        public static long INNER_STATIC_TIME = System.currentTimeMillis();
    }

    class InnerClass {
        public long INNER_TIME = 0;
        public InnerClass() {
            timeElapsed();
            INNER_TIME = System.currentTimeMillis();
        }
    }

    //单纯的为了耗时，来扩大时间差异
    private void timeElapsed() {
        for (int i = 0; i < 10000000; i++) {
            int a = new Random(100).nextInt(), b = new Random(100).nextInt();
            a = a + b;
        }
    }

}
