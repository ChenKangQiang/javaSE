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
        ThreadLocalDemo runnable1 = new ThreadLocalDemo();
        ThreadLocalDemo runnable2 = new ThreadLocalDemo();
        executorService.execute(runnable1);
        executorService.execute(runnable2);

        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        executorService.shutdown();

        /**
         * Output:
         * User(name=Tom26, email=Tom26@163.com)
         * User(name=Tom26, email=Tom26@163.com)
         */
    }

}
