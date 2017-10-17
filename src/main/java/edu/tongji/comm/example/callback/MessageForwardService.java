package edu.tongji.comm.example.callback;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author chenkangqiang
 * @Data 2017/10/13
 */
public class MessageForwardService {

    /**
     * 要完成回调，需要持有回调的具体实现
     *
     */
    private MessageCallBack messageCallBack;

    public MessageForwardService(MessageCallBack messageCallBack) {
        this.messageCallBack = messageCallBack;
    }

    /**
     * 消息处理
     * @return
     */
    public void deal() {
        //模拟处理延时
        try {
            TimeUnit.MICROSECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MessageCallBack.Message message = new MessageCallBack.Message();
        message.setContent("hello");
        message.setDate(new Date());
        message.setFrom("Tom");
        message.setTo("Mary");

        messageCallBack.respond(message);
    }

}