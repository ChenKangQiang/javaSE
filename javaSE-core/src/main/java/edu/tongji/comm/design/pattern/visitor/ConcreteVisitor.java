package edu.tongji.comm.design.pattern.visitor;

/**
 * @author chenkangqiang
 * @date 2017/9/1
 */


public class ConcreteVisitor extends Visitor {

    @Override
    public void visit(ConcreteElementA elementA) {
        /**
         * 操作ConcreteElementA
         */
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        /**
         * 操作ConcreteElementB
         */
    }
}
