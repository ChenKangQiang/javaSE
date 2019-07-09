package edu.tongji.comm.design.pattern.prototype;

/**
 * @author chenkangqiang
 * @date 2017/8/29
 * @Description
 */

/**
 * java中通用的原型模式实现方式
 */
public class ConcretePrototype implements Cloneable {

    @Override
    protected ConcretePrototype clone() throws CloneNotSupportedException {

        Object object = null;
        object = super.clone();
        return (ConcretePrototype) object;
    }



}
