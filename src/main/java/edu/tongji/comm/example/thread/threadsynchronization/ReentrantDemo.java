package edu.tongji.comm.example.thread.threadsynchronization;

/**
 * @Description:  演示synchronized的可重入
 * @Author: chenkangqiang
 * @Date: 2019-02-13
 */
public class ReentrantDemo {

    public static void main(String[] args) {
        Reentrant reentrant = new Reentrant();
        for (int i = 0; i < 5; i++) {
            new Thread(reentrant).start();
        }
    }

    private static class Reentrant implements Runnable {
        @Override
        public void run() {
            this.get();
        }

        public synchronized void get() {
            System.out.println(Thread.currentThread().getName());
            set();
        }

        public synchronized void set() {
            System.out.println(Thread.currentThread().getName());
        }
    }

}
