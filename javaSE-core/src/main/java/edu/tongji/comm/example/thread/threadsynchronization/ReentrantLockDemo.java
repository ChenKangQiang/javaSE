package edu.tongji.comm.example.thread.threadsynchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-02-13
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new Thread(counter, "thread1");
        Thread thread2 = new Thread(counter, "thread2");
        thread1.start();
        thread2.start();
    }


    private static class Counter implements Runnable {
        private int count = 0;
        private final Lock lock = new ReentrantLock();

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


}



