package edu.tongji.comm.design.pattern.strategy;

/**
 * @author chenkangqiang
 * @date 2017/9/1
 */

/**
 * 儿童票折扣类，属于具体策略
 */
public class ChildrenDiscount implements Discount {

    @Override
    public double calculate(double price) {
        System.out.println("儿童票");
        return price - 10;
    }



}
