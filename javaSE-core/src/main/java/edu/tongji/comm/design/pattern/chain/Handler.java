package edu.tongji.comm.design.pattern.chain;

/**
 * @author chenkangqiang
 * @date 2017/8/31
 * @Description
 */

/**
 * 职责链中的，抽象处理类
 */
public abstract class Handler {
    /**
     * 维持对下家的引用
      */
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(String request);
}
