package edu.tongji.comm.design.pattern.flyweight;

/**
 * @author chenkangqiang
 * @date 2017/9/1
 */

/**
 * //围棋棋子：抽象享元类
 */
public abstract class IgoChessman {

    public abstract String getColor();

    public void display() {
        System.out.println("棋子颜色：" + this.getColor());
    }

}
