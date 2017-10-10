package edu.tongji.comm.example.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author chenkangqiang
 * @Data 2017/9/23
 */
public class Client {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //线程A
        executorService.execute(() -> {
            Connection connection = ConnectionManager.getConnection();
            System.out.println(Thread.currentThread().getName() + " : " + connection);
        });

        //线程B
        executorService.execute(() -> {
            Connection connection = ConnectionManager.getConnection();
            System.out.println(Thread.currentThread().getName() + " : " + connection);
        });

        executorService.shutdown();

        /**
         * output:
         * pool-1-thread-2 : edu.tongji.comm.example.multithread.Connection@7f44dae7
         * pool-1-thread-1 : edu.tongji.comm.example.multithread.Connection@77884415
         */

    }

}
