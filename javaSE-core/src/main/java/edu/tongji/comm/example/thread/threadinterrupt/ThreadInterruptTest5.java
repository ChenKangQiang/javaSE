package edu.tongji.comm.example.thread.threadinterrupt;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-02-13
 */
public class ThreadInterruptTest5 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new ThreadInterruptTest5.MyThread();
        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();
        System.out.println("已调用线程的interrupt方法");
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    TimeUnit.SECONDS.sleep(3);
                }
            } catch (InterruptedException ex) {
                System.out.println("线程的中断状态:" + Thread.currentThread().isInterrupted());
            } finally {
                System.out.println("执行清理工作");
            }
        }

    }
}
