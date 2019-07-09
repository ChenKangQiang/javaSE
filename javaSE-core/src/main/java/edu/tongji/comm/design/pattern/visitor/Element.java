package edu.tongji.comm.design.pattern.visitor;

/**
 * @author chenkangqiang
 * @date 2017/9/1
 */

/**
 * 访问者模式，抽象元素类
 */
public interface Element {
    //元素接收访问者
    void accept(Visitor visitor);
}
