package edu.tongji.comm.design.pattern.chain.example;

/**
 * @author chenkangqiang
 * @date 2017/8/31
 * @Description
 */

/**
 * 具体处理者类，董事会
 */
public class Congress extends Approver {

    public Congress(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        System.out.println("召开董事会审批采购单：" + request.getNumber() + "，金额：" + request.getAmount() + "元，采购目的：" + request.getPurpose() + "。");
    }
}
