package edu.tongji.comm.example.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-02-01
 */
public class CompletableFutureDemo {


    public static void main(String[] args) throws InterruptedException {
        thenAccept();


        TimeUnit.MILLISECONDS.sleep(5000);
    }




    public static void thenAccept() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        System.out.println("future1");

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 200;
        });
        System.out.println("future1");
        future1.thenAcceptBoth(future2, (x, y) -> System.out.println(x * y));
        future1.thenAccept(System.out::println);
        future1.thenAcceptAsync(System.out::println);
        System.out.println("accept");

        CompletableFuture<String> applyFuture = future1.thenApply(integer -> integer + "hello");
        applyFuture.thenAccept(System.out::println);

        future1.thenRun(() -> System.out.println("run"));
    }





}
