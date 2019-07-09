package edu.tongji.comm.design.pattern.visitor.example;

/**
 * @Author chenkangqiang
 * @Data 2017/9/2
 * @Description
 */

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 全职员工类
 */

@Data
@AllArgsConstructor
public class FulltimeEmployee implements Employee {

    private String name;
    /**
     * 周薪
     */
    private double weeklyWage;
    /**
     * 工作时长，按小时计算
     */
    private int workTime;

    @Override
    public void accept(Department department) {
        department.visit(this);
    }
}
