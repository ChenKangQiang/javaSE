package edu.tongji.comm.design.pattern.memento;

/**
 * @Author chenkangqiang
 * @Data 2017/9/2
 */

import lombok.Data;

/**
 * 备忘录模式，原发器，原发器存储了原始数据，用于生成备忘录
 */

@Data
public class Originator {
    private String state;

    public Originator() { }

    //创建一个备忘录对象
    public Memento createMemento() {
        return new Memento(this);
    }

    //根据备忘录对象恢复原发器状态
    public void restoreMemento(Memento m) {
        state = m.getState();
    }
}
