package edu.tongji.comm.design.pattern.visitor;

/**
 * @author chenkangqiang
 * @date 2017/9/1
 */


public class ConcreteElementB implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationA() {
        //业务方法
    }
}
