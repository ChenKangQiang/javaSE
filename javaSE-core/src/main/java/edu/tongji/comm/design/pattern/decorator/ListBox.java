package edu.tongji.comm.design.pattern.decorator;

/**
 * @author chenkangqiang
 * @date 2017/8/31
 */
public class ListBox implements Component {
    @Override
    public void display() {
        System.out.println("显示列表框");
    }
}
