package edu.tongji.comm.example.thread.concurrencyutils.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author chenkangqiang
 * @Data 2017/10/18
 */
public class CacheHealthChecker extends BaseHealthChecker {

    public CacheHealthChecker(String serviceName, CountDownLatch latch) {
        super(serviceName, latch);
    }

    @Override
    public void verifyService() throws Exception {
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("CacheHealthCheck is OK");
    }

}
