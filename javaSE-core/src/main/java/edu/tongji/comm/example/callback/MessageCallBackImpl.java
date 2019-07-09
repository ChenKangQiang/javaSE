package edu.tongji.comm.example.callback;

import org.apache.commons.lang3.StringUtils;


/**
 * @Author chenkangqiang
 * @Data 2017/10/13
 */

public class MessageCallBackImpl implements MessageCallBack {

    @Override
    public Message filter(Message message) {
        if (StringUtils.isNotEmpty(message.getFrom())) {
            return message;
        } else {
            return null;
        }
    }
}
