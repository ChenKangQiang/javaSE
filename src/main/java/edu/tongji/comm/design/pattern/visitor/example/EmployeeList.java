package edu.tongji.comm.design.pattern.visitor.example;

/**
 * @Author chenkangqiang
 * @Data 2017/9/2
 * @Description
 */

import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * 员工列表类，具体的数据结构对象
 */

@Data
public class EmployeeList implements Employee {
    List<Employee> employees = Lists.newArrayList();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmloyee(Employee employee) {
        if (CollectionUtils.isNotEmpty(employees) && employees.contains(employee)) {
            employees.remove(employee);
        }
    }


    @Override
    public void accept(Department department) {
        for (Employee employee : employees) {
            employee.accept(department);
        }
    }
}
