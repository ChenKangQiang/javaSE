package edu.tongji.comm.design.pattern.chain.example;

/**
 * @author chenkangqiang
 * @date 2017/8/31
 * @Description
 */

/**
 * 抽象处理者
 */
public abstract class Approver {
    /**
     * 定义后继对象
     */
    protected Approver successor;
    /**
     * 审批者姓名
     */
    protected String name;

    public Approver(String name) {
        this.name = name;
    }


    public void setSuccessor(Approver successor) {
        this.successor = successor;
    }

    public abstract void processRequest(PurchaseRequest request);
}
