package edu.tongji.comm.design.pattern.memento;

/**
 * @Author chenkangqiang
 * @Data 2017/9/2
 */

import lombok.Data;

/**
 * 备忘录类
 */

@Data
public class Memento {

    private String state;

    //只有原发器才能访问备忘录
    public Memento(Originator o) {
        this.state = o.getState();
    }
}
