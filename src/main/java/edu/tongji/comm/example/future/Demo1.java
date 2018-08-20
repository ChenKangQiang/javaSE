package edu.tongji.comm.example.future;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/8/15
 */
public class Demo1 {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(5);
                return 100;
            }
        });

        try {
            System.out.println(future.get(2, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("超时");
        }

        try {
            System.out.println(future.get(10, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {

        }

    }


}
