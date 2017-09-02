package edu.tongji.comm.design.pattern.decorator;

import org.junit.Test;

/**
 * @author chenkangqiang
 * @date 2017/8/31
 */
public class Client {

    @Test
    public void test() {
        TextBox textBox = new TextBox();

        //一层进行装饰，增加滚动条
        System.out.println("一层装饰");
        ScrollBarDecorator scrollBarDecorator = new ScrollBarDecorator(textBox);
        scrollBarDecorator.dispaly();

        System.out.println("**********************************");
        System.out.println("二层装饰");
        //二层装饰，添加黑色边框
        BlackBorderDecorator blackBorderDecorator = new BlackBorderDecorator(new ScrollBarDecorator(textBox));
        blackBorderDecorator.display();
    }

}
