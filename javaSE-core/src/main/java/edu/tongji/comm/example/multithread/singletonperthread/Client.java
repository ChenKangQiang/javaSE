package edu.tongji.comm.example.multithread.singletonperthread;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author chenkangqiang
 * @Data 2017/10/10
 */
public class Client {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        //测试不同线程的单例是否是同一个
        executorService.execute(new ThreadLocalSingleton());
        executorService.execute(new ThreadLocalSingleton());
        executorService.execute(new ThreadLocalSingleton());
        executorService.shutdown();
    }


    /**
     * 多线程的单元测试，主线程必须sleep一段时间才能看到子线程的运行结果
     *
     */
    @Test
    public void test() {
        executorService.execute(new ThreadLocalSingleton());
        executorService.execute(new ThreadLocalSingleton());
        executorService.execute(new ThreadLocalSingleton());

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }



}
