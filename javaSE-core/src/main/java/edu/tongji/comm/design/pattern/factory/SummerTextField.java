package edu.tongji.comm.design.pattern.factory;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description
 */
public class SummerTextField implements TextField {

    @Override
    public void display() {
        System.out.println("显示浅蓝色边框文本框");
    }
}
