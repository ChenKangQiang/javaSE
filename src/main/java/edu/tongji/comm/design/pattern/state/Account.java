package edu.tongji.comm.design.pattern.state;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author chenkangqiang
 * @Data 2017/9/3
 * 账户类，属于环境类
 */

@Data
public class Account {
    /**
     * 维持一个对抽象状态对象的引用，默认为正常状态
     */
    private AccountState state = new NormalState(this);
    private String owner; //开户名
    private double balance = 0; //账户余额

    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    /**
     * 存款
     * @param amount
     */
    public void deposit(double amount) {
        System.out.println(this.owner + "存款" + amount);
        state.deposit(amount); //调用状态对象的deposit()方法
        System.out.println("现在余额为" + this.balance);
        System.out.println("现在帐户状态为" + this.state.getClass().getName());
        System.out.println("---------------------------------------------");
    }

    /**
     * 取款
     * @param amount
     */
    public void withdraw(double amount) {
        System.out.println(this.owner + "取款" + amount);
        state.withdraw(amount); //调用状态对象的withdraw()方法
        System.out.println("现在余额为" + this.balance);
        System.out.println("现在帐户状态为" + this.state.getClass().getName());
        System.out.println("---------------------------------------------");
    }

    public void computeInterest() {
        state.computeInterest(); //调用状态对象的computeInterest()方法
    }
}
