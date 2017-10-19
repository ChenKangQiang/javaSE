package edu.tongji.comm.example.concurrency_utils_demo.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author chenkangqiang
 * @Data 2017/10/19
 */

/**
 * Semaphore规定了允许使用资源的客户数
 * 每个线程要使用资源，必须先调用acquire()来获取许可，若当前无许可，则进入阻塞状态
 * 线程使用完后，需要调用release()释放许可
 */
public class App {

    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(3);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }

            });
        }

        executorService.shutdown();
    }

}
