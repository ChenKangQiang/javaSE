package edu.tongji.comm.design.pattern.prototype;

/**
 * @author chenkangqiang
 * @date 2017/8/29
 * @Description
 */

import lombok.Data;

/**
 * 每日周报作为具体原型类，Cloneable接口没有定义任何方法，是一个标识接口
 */

@Data
public class WeeklyLog implements Cloneable {
    private String name;
    private String date;
    private String content;

    private Attachment attachment;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
