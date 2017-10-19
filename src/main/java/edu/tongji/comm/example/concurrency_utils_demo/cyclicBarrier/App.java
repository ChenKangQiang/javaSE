package edu.tongji.comm.example.concurrency_utils_demo.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author chenkangqiang
 * @Data 2017/10/18
 */

/**
 * CyclicBarrier是一个循环障碍，每当凑齐N个线程，就一起继续执行下一步，否则就等待。跟小货车拉人一样，人满了就出发
 * 与CountDownLatch的区别在于，CountDownLatch是要1个线程等待其他N-1个线程
 * 而CyclicBarrier则是N个线程均相互等待，直到线程数量到大阈值，大家一起执行下一步
 */
public class App {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> System.out.println("begin"));

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            executorService.execute(new Sportsman("Tom" + i, cyclicBarrier));
        }

        executorService.shutdown();

    }
}
