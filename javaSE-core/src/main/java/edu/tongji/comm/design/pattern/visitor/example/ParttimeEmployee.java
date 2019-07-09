package edu.tongji.comm.design.pattern.visitor.example;

/**
 * @Author chenkangqiang
 * @Data 2017/9/2
 * @Description
 */

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 临时员工类
 */

@Data
@AllArgsConstructor
public class ParttimeEmployee implements Employee {

    private String name;
    /**
     * 临时员工按时薪计算
     */
    private double hourWage;
    private int workTime;

    @Override
    public void accept(Department department) {
        department.visit(this);
    }
}
