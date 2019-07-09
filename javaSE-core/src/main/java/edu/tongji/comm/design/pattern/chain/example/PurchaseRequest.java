package edu.tongji.comm.design.pattern.chain.example;

/**
 * @author chenkangqiang
 * @date 2017/8/31
 * @Description
 */

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 请求类
 */
@Data
@AllArgsConstructor
public class PurchaseRequest {
    /**
     * 采购金额
     */
    private double amount;
    /**
     * 采购单编号
     */
    private int number;
    /**
     * 采购目的
     */
    private String purpose;
}
