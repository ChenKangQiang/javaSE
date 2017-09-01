package edu.tongji.comm.design.pattern.visitor;

/**
 * @author chenkangqiang
 * @date 2017/9/1
 */

/**
 * 访问者模式，抽象访问者，抽象了对不同对象的访问
 */
public abstract class Visitor {

    public abstract void visit(ConcreteElementA elementA);
    public abstract void visit(ConcreteElementB elementB);
    public void visit(ConcreteElementC elementC) {
        //元素ConcreteElementC操作代码
    }

}
