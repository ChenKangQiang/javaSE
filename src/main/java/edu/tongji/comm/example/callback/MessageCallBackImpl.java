package edu.tongji.comm.example.callback;

import lombok.Data;

import java.util.Date;

/**
 * @Author chenkangqiang
 * @Data 2017/10/13
 */

public class MessageCallBackImpl implements MessageCallBack {

    private Message response;


    @Override
    public void respond(Message message) {
        this.response = message;
        System.out.println(response);
    }
}
