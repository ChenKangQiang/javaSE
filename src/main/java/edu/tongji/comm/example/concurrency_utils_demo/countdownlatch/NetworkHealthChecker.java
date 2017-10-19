package edu.tongji.comm.example.concurrency_utils_demo.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author chenkangqiang
 * @Data 2017/10/18
 */
public class NetworkHealthChecker extends BaseHealthChecker {

    public NetworkHealthChecker(String serviceName, CountDownLatch latch) {
        super(serviceName, latch);
    }

    @Override
    public void verifyService() throws Exception {
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("NetworkHealthCheck is OK");
    }
}
