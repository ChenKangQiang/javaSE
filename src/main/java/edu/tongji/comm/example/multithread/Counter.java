package edu.tongji.comm.example.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author chenkangqiang
 * @Data 2017/9/23
 */
public class Counter implements Runnable {
    private static int count = 0;


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Counter());
        executorService.submit(new Counter());
        executorService.submit(new Counter());
        executorService.shutdown();
    }


    @Override
    public void run() {
        try {
            while (count < 500) {
                if (!Thread.currentThread().isInterrupted()) {
                    TimeUnit.MILLISECONDS.sleep(200);
                    count++;
                    System.out.println(Thread.currentThread().getName() + " : " + count);
                }
            }
        } catch (InterruptedException ex) {
           ex.printStackTrace();
        }

    }


}
