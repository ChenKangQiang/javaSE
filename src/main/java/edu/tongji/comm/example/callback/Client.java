package edu.tongji.comm.example.callback;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author chenkangqiang
 * @Data 2017/10/13
 *
 * 客户端调用消息转发服务MessageForwardService，消息转发成功后，服务回调响应
 */
public class Client {

    public static void main(String[] args) {
        MessageCallBack callBack = new MessageCallBackImpl();
        MessageForwardService msf = new MessageForwardService(callBack);

        new Thread(() -> msf.deal()).start();

        try {
            TimeUnit.MICROSECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("回调成功");
    }

}
