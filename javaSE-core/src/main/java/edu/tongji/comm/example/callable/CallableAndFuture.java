package edu.tongji.comm.example.callable;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author chenkangqiang
 * @Data 2017/10/11
 */
public class CallableAndFuture {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };

        //使用Thread和FutureTask
        FutureTask<Integer> future1 = new FutureTask<Integer>(() -> new Random().nextInt(100));
        new Thread(future1).start();

        //使用线程池
        Future<Integer> future2 = executorService.submit(() -> new Random().nextInt(100));


        try {
            Thread.sleep(5000);// 可能做一些事情
            System.out.println(future1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
