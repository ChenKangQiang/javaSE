package edu.tongji.comm.example.thread.pool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-03-06
 */
public class PoolDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(30, 100, 60,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(300));
        //设置核心线程也受超时时间影响
        executor.allowCoreThreadTimeOut(true);
        //设置所有线程核心线程初始化
        executor.prestartAllCoreThreads();
    }


}
