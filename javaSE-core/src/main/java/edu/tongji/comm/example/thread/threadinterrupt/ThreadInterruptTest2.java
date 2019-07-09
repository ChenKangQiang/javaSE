package edu.tongji.comm.example.thread.threadinterrupt;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-02-12
 */
public class ThreadInterruptTest2 {

    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
        t.interrupt();
        System.out.println("已调用线程的interrupt方法");
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            long num = -1;
            try {
                num = longTimeRunningInterruptMethod(10);
            } catch (InterruptedException ex) {
                System.out.println("线程被中断");
                ex.printStackTrace();
            }
            System.out.println("长时间任务运行结束,num=" + num);
            //抛出中断异常后，线程的中断状态会被重置为false
            System.out.println("线程的中断状态:" + Thread.currentThread().isInterrupted());
        }

        private long longTimeRunningInterruptMethod(int count) throws InterruptedException {
            long initNum = 0;
            for (int i = 0; i < count; i++) {
                TimeUnit.SECONDS.sleep(5);
            }
            return initNum;
        }
    }

}
