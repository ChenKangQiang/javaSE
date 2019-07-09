package edu.tongji.comm.design.pattern.state;

/**
 * @Author chenkangqiang
 * @Data 2017/9/3
 * 抽象状态类，不同状态下的操作不同，当account是同一个
 */
public abstract class AccountState {
    protected Account account;

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void computeInterest();
    public abstract void stateCheck();
}
