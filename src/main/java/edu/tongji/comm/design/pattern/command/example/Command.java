package edu.tongji.comm.design.pattern.command.example;

/**
 * @Author chenkangqiang
 * @Data 2017/9/2
 * @Description
 */

/**
 * 抽象命令类
 */
public interface Command {

    /**
     * 命令执行方法
     * @param value
     * @return
     */
    int execute(int value);

    /**
     * 命令撤销方法
     * @return
     */
    int undo();
}
