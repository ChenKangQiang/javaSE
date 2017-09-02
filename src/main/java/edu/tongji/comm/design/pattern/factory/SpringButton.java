package edu.tongji.comm.design.pattern.factory;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description
 */
public class SpringButton implements Button {

    @Override
    public void display() {
        System.out.println("显示浅绿色按钮");
    }

}
