package edu.tongji.comm.design.pattern.factory;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description
 */
public class SpringTextField implements TextField {

    @Override
    public void display() {
        System.out.println("显示浅绿色边框文本框");
    }

}
