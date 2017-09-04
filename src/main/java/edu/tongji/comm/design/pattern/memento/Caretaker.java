package edu.tongji.comm.design.pattern.memento;

/**
 * @Author chenkangqiang
 * @Data 2017/9/2
 */
public class Caretaker {

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
