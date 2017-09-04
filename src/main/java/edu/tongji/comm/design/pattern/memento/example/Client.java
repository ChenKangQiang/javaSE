package edu.tongji.comm.design.pattern.memento.example;

import org.junit.Test;

/**
 * @Author chenkangqiang
 * @Data 2017/9/2
 */
public class Client {

    @Test
    public void test() {
        MementoCaretaker mc = new MementoCaretaker();
        Chessman chess = new Chessman("车",1,1);
        System.out.println(chess);
        mc.setMemento(chess.save()); //保存状态

        chess.setY(4);
        System.out.println(chess);
        mc.setMemento(chess.save()); //保存状态
        System.out.println(chess);

        chess.setX(5);
        System.out.println(chess);
        System.out.println("******悔棋******");
        chess.restore(mc.getMemento()); //恢复状态
        System.out.println(chess);
    }


    @Test
    public void testWithInnerClass() {
        MementoCaretaker mc = new MementoCaretaker();
        ChessmanWithInnerClass chess = new ChessmanWithInnerClass("车",1,1);

        //保存状态
        chess.save();
        System.out.println(chess);

        chess.setY(4);
        chess.save();
        System.out.println(chess);

        chess.setX(5);
        chess.save();
        System.out.println(chess);

        System.out.println("******悔棋******");
        chess.restore(); //恢复状态
        System.out.println(chess);
    }

}
