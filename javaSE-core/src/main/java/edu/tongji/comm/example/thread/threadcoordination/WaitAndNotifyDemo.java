package edu.tongji.comm.example.thread.threadcoordination;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-02-14
 */
public class WaitAndNotifyDemo {

    public static void main(String[] args) {
        Resource resource = new Resource();
        Consumer consumer = new Consumer(resource);
        Producer producer = new Producer(resource);
        Thread consumerThread1 = new Thread(consumer, "ConsumerThread1");
        Thread consumerThread2 = new Thread(consumer, "ConsumerThread2");
        Thread thread2 = new Thread(producer);
        consumerThread1.start();
        consumerThread2.start();
        thread2.start();
    }


    @Data
    private static class Resource {
        private boolean ready = false;
    }


    @AllArgsConstructor
    private static class Producer implements Runnable {
        private Resource resource;

        @Override
        public void run() {
            synchronized (resource) {
                System.out.println("进入生产者线程");
                System.out.println("生产");
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);  //模拟生产过程
                    resource.setReady(true);
                    //resource.notify();  //通知消费者
                    resource.notifyAll();
                    TimeUnit.MILLISECONDS.sleep(1000);  //模拟其他耗时操作
                    System.out.println("退出生产者线程");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @AllArgsConstructor
    static class Consumer implements Runnable {
        private Resource resource;

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            synchronized (resource) {
                System.out.println("进入消费者线程" + threadName);
                System.out.println(threadName + " wait flag 1:" + resource.isReady());
                while (!resource.isReady()) {  //判断条件是否满足，若不满足则等待
                    try {
                        System.out.println("还没生产，进入等待");
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(threadName + "结束等待");
                System.out.println(threadName + " wait flag 2:" + resource.isReady());
                System.out.println(threadName + "消费");
                resource.setReady(false);
                System.out.println("退出消费者线程" + threadName);
            }
        }
    }


}
