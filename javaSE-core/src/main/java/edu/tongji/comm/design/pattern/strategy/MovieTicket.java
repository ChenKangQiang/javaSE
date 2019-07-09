package edu.tongji.comm.design.pattern.strategy;

/**
 * @author chenkangqiang
 * @date 2017/9/1
 *
 * java中GUI的布局管理器就是采用了策略模式，通过setLayout()来设置布局策略
 */



/**
 * 策略模式，环境类
 */
public class MovieTicket {

    private double price;

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 保留策略的抽象引用
     */
    private Discount discount;

    public double getPrice() {
       return discount.calculate(price);
    }
}
