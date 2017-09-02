package edu.tongji.comm.memento.example;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @Author chenkangqiang
 * @Data 2017/9/2
 */

@Data
public class ChessmanWithInnerClass {
    private String label;
    private int x;
    private int y;

    private int index = -1;
    private List<ChessmanMemento> lst = Lists.newArrayList();

    public ChessmanWithInnerClass(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    //使用内部类，这样的话，可以确保只有原发器才能生成备忘录
    @Data
    private static class ChessmanMemento {
        private String label;
        private int x;
        private int y;
        public ChessmanMemento(String label, int x, int y) {
            this.label = label;
            this.x = x;
            this.y = y;
        }
    }

    //每次修改原发器的状态，就会生成一个备忘录
    public void save() {
        index++;
        lst.add(new ChessmanMemento(label, x, y));
    }

    //恢复状态
    public void restore() {
        ChessmanMemento memento = lst.get(index - 1);
        index--;
        this.label = memento.getLabel();
        this.x = memento.getX();
        this.y = memento.getY();
    }
}
