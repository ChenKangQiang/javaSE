package edu.tongji.comm.example.thread.threadcoordination;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-02-14
 */
public class ConditionDemo {

    public static void main(String[] args) {
        Resource resource = new Resource();
        Consumer consumer = new Consumer(resource);
        Producer producer = new Producer(resource);
        Thread thread1 = new Thread(consumer);
        Thread thread2 = new Thread(producer);
        thread1.start();
        thread2.start();
    }


    @Data
    private static class Resource {
        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();
        //一个ReentrantLock可以绑定多个condition
        private final Condition conditionB = lock.newCondition();
        private boolean ready = false;

        public void consumeResource() {
            lock.lock();
            try {
                while (!this.ready) {
                    try {
                        System.out.println("生产者未准备好资源，消费者进入等待");
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费者消费资源完毕");
                this.ready = false;
            } finally {
                lock.unlock();
            }
        }


        public void produceResource() {
            lock.lock();
            try {
                if (!this.ready) {
                    this.ready = true;
                    System.out.println("生产者已准备好资源，通知消费者");
                    condition.signal();
                }
            } finally {
                lock.unlock();
            }
        }

    }


    @AllArgsConstructor
    private static class Producer implements Runnable {
        private Resource resource;

        @Override
        public void run() {
            resource.produceResource();
        }
    }


    @AllArgsConstructor
    static class Consumer implements Runnable {
        private Resource resource;

        @Override
        public void run() {
            resource.consumeResource();
        }
    }


}
