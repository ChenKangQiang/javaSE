package edu.tongji.comm.design.pattern.state;

import org.junit.Test;

/**
 * @Author chenkangqiang
 * @Data 2017/9/3
 */
public class Client {

    @Test
    public void test() {
        Account acc = new Account("段誉",0.0);
        acc.deposit(1000);
        acc.withdraw(2000);
        acc.deposit(3000);
        acc.withdraw(4000);
        acc.withdraw(1000);
        acc.computeInterest();
    }
}
