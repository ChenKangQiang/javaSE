package edu.tongji.comm.design.pattern.command.example;

import org.junit.Test;

/**
 * @Author chenkangqiang
 * @Data 2017/9/2
 */
public class Client {

    @Test
    public void test() {
        Command command = new ConcreteCommand();
        for (int i = 0; i < 10; i++) {
            System.out.println(command.execute(i));
        }
        System.out.println("***********全部撤销************");
        for (int i = 0; i < 10; i++) {
            System.out.println(command.undo());
        }
    }

}
