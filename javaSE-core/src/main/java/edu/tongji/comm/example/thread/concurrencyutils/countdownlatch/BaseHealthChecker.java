package edu.tongji.comm.example.thread.concurrencyutils.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static jdk.nashorn.internal.objects.NativeError.printStackTrace;

/**
 * @Author chenkangqiang
 * @Data 2017/10/18
 */
public class BaseHealthChecker implements Runnable {

    private CountDownLatch latch;
    private String serviceName;
    private boolean serviceUp;

    public BaseHealthChecker(String serviceName, CountDownLatch latch) {
        super();
        this.latch = latch;
        this.serviceName = serviceName;
        this.serviceUp = false;
    }

    @Override
    public void run() {
        try {
            verifyService();
            serviceUp = true;
        } catch (Exception ex) {
            printStackTrace(ex);
            serviceUp = false;
        } finally {
            if(latch != null) {
                latch.countDown();    //线程执行完时，调用countDown()，则该线程会进入阻塞，等待其他线程完成
            }
        }
    }

    public String getServiceName() {
        return serviceName;
    }

    public boolean isServiceUp() {
        return serviceUp;
    }

    public void verifyService() throws Exception {
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.println("BaseHealthCheck is OK");
    }

}
