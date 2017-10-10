package edu.tongji.comm.example.multithread.singletonperthread;

import java.util.Random;

/**
 * @Author chenkangqiang
 * @Data 2017/10/10
 *
 * 由于threadlocal与线程绑定，所以需要在线程中获取单例
 */
public class ThreadLocalSingleton implements Runnable {

    @Override
    public void run() {
        Singleton instance1 = Singleton.getInstance();
        System.out.println(getThreadName() + instance1);
        sleep(100, 50); // sleep for some time
        Singleton instance2 = Singleton.getInstance();
        System.out.println(getThreadName() + instance2);
        boolean equal = instance1 == instance2;
        String message = equal ? "Both are equal" : "Not equal";
        System.out.println(getThreadName() + message);
    }

    private void sleep(int max, int min) {
        try {
            int time = new Random().nextInt(max - min + 1) + min;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getThreadName() {
        return "[" + Thread.currentThread().getName() + "] - ";
    }
}
