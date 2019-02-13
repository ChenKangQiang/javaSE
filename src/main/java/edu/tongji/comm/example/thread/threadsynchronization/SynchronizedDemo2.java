package edu.tongji.comm.example.thread.threadsynchronization;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-02-13
 */
public class SynchronizedDemo2 {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread3 = new Thread(counter, "A");
        Thread thread4 = new Thread(counter, "B");
        thread3.start();
        thread4.start();
    }

    private static class Counter implements Runnable {
        private int count;

        public void countAdd() {
            synchronized(this) {
                for (int i = 0; i < 5; i ++) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ":" + (count++));
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        public synchronized void countAddV2() {
            for (int i = 0; i < 5; i ++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        //非synchronized代码块，未对count进行读写操作，所以可以不用synchronized
        public void printCount() {
            for (int i = 0; i < 5; i ++) {
                try {
                    System.out.println(Thread.currentThread().getName() + " count:" + count);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void run() {
            String threadName = Thread.currentThread().getName();
            if (threadName.equals("A")) {
                countAdd();
                //countAddV2();
            } else if (threadName.equals("B")) {
                printCount();
            }
        }
    }
}
