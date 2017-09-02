package edu.tongji.comm.design.pattern.decorator;

/**
 * @author chenkangqiang
 * @date 2017/8/31
 */

/**
 * 滚动条装饰器类
 */
public class ScrollBarDecorator extends ComponentDecorator {

    public ScrollBarDecorator(Component component) {
        super(component);
    }

    public void dispaly() {
        this.setScrollBar();
        super.display();
    }

    public void setScrollBar() {
        System.out.println("为构件增加滚动条！");
    }

}
