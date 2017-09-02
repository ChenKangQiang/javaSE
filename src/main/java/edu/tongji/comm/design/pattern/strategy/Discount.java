package edu.tongji.comm.design.pattern.strategy;

/**
 * @author chenkangqiang
 * @date 2017/9/1
 */

/**
 * 策略模式，抽象策略类
 */
public interface Discount {
    double calculate(double price);
}
