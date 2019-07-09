package edu.tongji.comm.example.thread.concurrencyutils.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Author chenkangqiang
 * @Data 2017/10/18
 */
public class Sportsman implements Runnable {

    private String name;
    private CyclicBarrier barrier;
    private static Random random = new Random();
    private int cycleTime;
    private int count;

    public Sportsman(String name, CyclicBarrier barrier, int cycleTime) {
        this.name = name;
        this.barrier = barrier;
        this.cycleTime = cycleTime;
    }


    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println(name + " is ready");
            while (count < cycleTime) {
                barrier.await();    //CyclicBarrier可重用
                System.out.println(name + " has run " + random.nextInt(10) + " m");
                count++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }


}
