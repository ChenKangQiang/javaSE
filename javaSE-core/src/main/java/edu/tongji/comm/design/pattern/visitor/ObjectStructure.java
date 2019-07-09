package edu.tongji.comm.design.pattern.visitor;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * @author chenkangqiang
 * @date 2017/9/1
 */
public class ObjectStructure {

    private List<Element> list = Lists.newArrayList(); //定义一个集合用于存储元素对象

    //遍历所有元素，访问者可以根据不同element，动态调用相应的方法
    public void accept(Visitor visitor) {
        for (Element element : list) {
            element.accept(visitor);
        }
    }

    public void addElement(Element element) {
        list.add(element);
    }

    public void removeElement(Element element) {
        list.remove(element);
    }

}
