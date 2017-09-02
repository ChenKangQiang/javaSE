package edu.tongji.comm.design.pattern.command;

/**
 * @Author chenkangqiang
 * @Data 2017/9/2
 * @Description
 */
public class CalculatorForm {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    //调用命令对象的execute()方法执行运算
    public void compute(int value) {
        int i = command.execute(value);
        System.out.println("执行运算，运算结果为：" + i);
    }

    //调用命令对象的undo()方法执行撤销
    public void undo() {
        int i = command.undo();
        System.out.println("执行撤销，运算结果为：" + i);
    }

}
