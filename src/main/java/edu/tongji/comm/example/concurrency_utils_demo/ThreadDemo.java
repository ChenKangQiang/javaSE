package edu.tongji.comm.example.concurrency_utils_demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/8/26
 */
public class ThreadDemo {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
            }
        });
    }


}
