package edu.tongji.comm.example.servlet;

import java.util.concurrent.TimeUnit;

/**
 * @author chenkangqiang
 * @date 2017/9/29
 */
public class LongRunningProcess {

    public void process() {
        try {
            System.out.println(Thread.currentThread().getName() + " is processing task! ");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
