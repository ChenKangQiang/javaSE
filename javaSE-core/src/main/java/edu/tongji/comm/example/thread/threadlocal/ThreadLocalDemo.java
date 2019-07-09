package edu.tongji.comm.example.thread.threadlocal;

import org.apache.commons.lang3.RandomUtils;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-03-01
 */
public class ThreadLocalDemo {

    private static final ThreadLocal<Integer> INTEGER_THREAD_LOCAL = ThreadLocal.withInitial(() -> 100);
    private static final ThreadLocal<String> STRING_THREAD_LOCAL = ThreadLocal.withInitial(() -> "Hello");


    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task());
        Thread thread2 = new Thread(new Task());
        thread1.start();
        thread2.start();
    }

    private static class Task implements Runnable {

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println("修改" + threadName + "的值");
            INTEGER_THREAD_LOCAL.set(INTEGER_THREAD_LOCAL.get() + RandomUtils.nextInt());
            System.out.println(threadName + ":" + INTEGER_THREAD_LOCAL.get());
            STRING_THREAD_LOCAL.set(threadName + ":" + STRING_THREAD_LOCAL.get());
            System.out.println(STRING_THREAD_LOCAL.get());
        }
    }


}
