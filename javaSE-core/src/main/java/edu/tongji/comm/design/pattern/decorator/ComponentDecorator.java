package edu.tongji.comm.design.pattern.decorator;

/**
 * @author chenkangqiang
 * @date 2017/8/31
 */

/**
 * 装饰器模式，抽象装饰类
 */
public abstract class ComponentDecorator implements Component {

    /**
     * 维持一个抽象构建
     */
    protected Component component;

    @Override
    public void display() {
        component.display();
    }

    /**
     * 注入一个具体构建
     *
     * @param component
     */
    protected ComponentDecorator(Component component) {
        this.component = component;
    }

}
