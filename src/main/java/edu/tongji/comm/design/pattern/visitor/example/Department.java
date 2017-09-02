package edu.tongji.comm.design.pattern.visitor.example;

/**
 * @Author chenkangqiang
 * @Data 2017/9/2
 * @Description
 */

/**
 * 抽象访问者，部门
 */
public abstract class Department {

    //声明一组重载的访问方法，用于访问不同类型的具体元素
    public abstract void visit(FulltimeEmployee employee);
    public abstract void visit(ParttimeEmployee employee);

}
