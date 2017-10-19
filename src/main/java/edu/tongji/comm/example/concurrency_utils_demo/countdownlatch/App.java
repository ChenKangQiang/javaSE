package edu.tongji.comm.example.concurrency_utils_demo.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author chenkangqiang
 * @Data 2017/10/18
 */


/**
 * 主线程必须在启动其他线程后立即调用CountDownLatch.await()方法，这样主线程的操作就会在这个方法上阻塞，直到其他线程完成各自的任务。
 *
 * 其他N个线程必须引用闭锁对象，因为他们需要通知CountDownLatch对象，
 * 若某个任务完成，则调用CountDownLatch.countDown()方法来完成的，每调用一次这个方法，在构造函数中初始化的count值就减1。
 * 所以当N个线程都调用了这个方法，count的值等于0，然后主线程就能通过await()方法，恢复执行自己的任务。
 */
public class App {

    public static void main(String[] args) {

        List<BaseHealthChecker> healthCheckers = new ArrayList<>();

        //这里设置为4个线程，因为存在4个子线程
        CountDownLatch latch = new CountDownLatch(4);

        healthCheckers.add(new BaseHealthChecker("BaseHealthChecker", latch));
        healthCheckers.add(new CacheHealthChecker("CacheHealthChecker", latch));
        healthCheckers.add(new DatabaseHealthChecker("DatabaseHealthChecker", latch));
        healthCheckers.add(new NetworkHealthChecker("NetworkHealthChecker", latch));

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (BaseHealthChecker checker : healthCheckers) {
            executorService.execute(checker);
        }

        //主线程完成后等待
        try {
            latch.await();    //只有当CountDownLatch中的count为0，即所有子任务完成时，主线程才会继续执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("所有检查均通过");
        executorService.shutdown();

    }


}
