package edu.tongji.comm.example.thread.threadsynchronization;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-02-13
 */
public class SynchronizedDemo1 {


    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        Thread thread1 = new Thread(syncThread, "SyncThread1");
        Thread thread2 = new Thread(syncThread, "SyncThread2");
        thread1.start();
        thread2.start();
    }





    static class SyncThread implements Runnable {
        private int count = 0;

        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ":" + (count++));
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public synchronized void method() {

        }

        public synchronized static void staticMethod() {

        }

    }







}
