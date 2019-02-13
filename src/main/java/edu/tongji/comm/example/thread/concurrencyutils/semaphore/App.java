package edu.tongji.comm.example.thread.concurrencyutils.semaphore;

import lombok.AllArgsConstructor;

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
        final Semaphore semaphore = new Semaphore(3);  //机器数目3
        ExecutorService executorService = Executors.newFixedThreadPool(10); //10个工人
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Worker(i, semaphore));
        }
        executorService.shutdown();
    }


    @AllArgsConstructor
    private static class Worker extends Thread {
        private int num;
        private Semaphore semaphore;

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人" + this.num + "占用一个机器在生产...");
                Thread.sleep(1000);
                System.out.println("工人" + this.num + "释放出机器");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }

}
