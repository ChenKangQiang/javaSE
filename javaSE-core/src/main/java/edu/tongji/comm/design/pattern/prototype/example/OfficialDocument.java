package edu.tongji.comm.design.pattern.prototype.example;

/**
 * @author chenkangqiang
 * @date 2017/8/29
 * @Description
 */

/**
 * 抽象公文接口类
 */
public interface OfficialDocument extends Cloneable {
    OfficialDocument clone();
    void display();
}
