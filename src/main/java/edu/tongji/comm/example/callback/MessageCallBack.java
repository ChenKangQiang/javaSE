package edu.tongji.comm.example.callback;

import lombok.Data;

import java.util.Date;

/**
 * @Author chenkangqiang
 * @Data 2017/10/12
 *
 * 回调接口
 */
public interface MessageCallBack {

    void respond(MessageCallBack.Message message);

    @Data
    public static class Message {
        private String content;
        private Date date;
        private String from;
        private String to;
    }
}
