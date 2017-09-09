package edu.tongji.comm.design.pattern.memento.example;

/**
 * @Author chenkangqiang
 * @Data 2017/9/2
 */
public class MementoCaretaker {

    private ChessmanMemento memento;

    public ChessmanMemento getMemento() {
        return memento;
    }

    public void setMemento(ChessmanMemento memento) {
        this.memento = memento;
    }

}
