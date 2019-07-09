package edu.tongji.comm.design.pattern.command;

/**
 * @Author chenkangqiang
 * @Data 2017/9/2
 * @Description
 */

/**
 * 加法器
 */
public class Adder {



    private int num = 0;

    /**加法操作，每次将传入的值与num作加法运算，再将结果返回
     * @param value
     * @return
     */
    public int add(int value) {
        num += value;
        return num;
    }

}
