package edu.tongji.comm.design.pattern.visitor.example;

/**
 * @Author chenkangqiang
 * @Data 2017/9/2
 * @Description
 */

/**
 * 抽象元素类，员工
 */
public interface Employee {
    /**
     * 元素接受访问者的访问
     */
    void accept(Department department);
}
