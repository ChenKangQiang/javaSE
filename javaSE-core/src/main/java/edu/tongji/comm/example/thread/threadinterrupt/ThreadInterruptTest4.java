package edu.tongji.comm.example.thread.threadinterrupt;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-02-12
 */
public class ThreadInterruptTest4 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new ThreadInterruptTest4.MyThread();
        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();
        System.out.println("已调用线程的interrupt方法");
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException ex) {
                    //抛出InterruptedException异常后，会自动清除中断表示
                    System.out.println("线程的中断状态:" + Thread.currentThread().isInterrupted());
                    //需要重新设置中断，才能跳出while循环
                    Thread.currentThread().interrupt();
                    System.out.println("重新interrupt()后，线程的中断状态:" + Thread.currentThread().isInterrupted());
                } finally {
                    System.out.println("执行清理工作");
                }
            }
        }

    }

}
