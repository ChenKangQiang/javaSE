package edu.tongji.comm.design.pattern.memento.example;

/**
 * @Author chenkangqiang
 * @Data 2017/9/2
 */

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 棋子备忘录类
 */

@Data
@AllArgsConstructor
public class ChessmanMemento {
    private String label;
    private int x;
    private int y;
}
