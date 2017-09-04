package edu.tongji.comm.design.pattern.memento.example;

/**
 * @Author chenkangqiang
 * @Data 2017/9/2
 */

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 象棋棋子类，原发器
 */

@Data
@AllArgsConstructor
public class Chessman {

    private String label;
    private int x;
    private int y;

    //每次修改原发器的状态，就会生成一个备忘录
    public ChessmanMemento save() {
        return new ChessmanMemento(this.label,this.x,this.y);
    }

    //恢复状态
    public void restore(ChessmanMemento memento) {
        this.label = memento.getLabel();
        this.x = memento.getX();
        this.y = memento.getY();
    }

}
