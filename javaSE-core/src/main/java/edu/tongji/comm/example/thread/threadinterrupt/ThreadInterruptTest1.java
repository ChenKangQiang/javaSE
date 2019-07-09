package edu.tongji.comm.example.thread.threadinterrupt;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-02-12
 */
public class ThreadInterruptTest1 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        TimeUnit.MILLISECONDS.sleep(100);
        t.interrupt();
        System.out.println("已调用线程的interrupt方法");
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            long num = 0;
            while (true) {
                //非阻塞类型的中断需要手动检查处理
                if (!Thread.currentThread().isInterrupted()) {
                    num = num + this.longTimeRunningNonInterruptMethod(10);
                } else {
                    System.out.println("长时间任务运行结束, num=" + num);
                    System.out.println("线程的中断状态:" + Thread.currentThread().isInterrupted());
                    break;
                }
            }
        }

        private long longTimeRunningNonInterruptMethod(int count) {
            long initNum = 0;
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < Integer.MAX_VALUE; j++) {
                    initNum++;
                }
            }
            return initNum;
        }
    }



}
