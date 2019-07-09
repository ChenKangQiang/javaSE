package edu.tongji.comm.design.pattern.visitor.example;

import org.junit.Test;

/**
 * @Author chenkangqiang
 * @Data 2017/9/2
 * @Description
 */
public class Client {

    @Test
    public void test() {
        EmployeeList lst = new EmployeeList();
        Employee employee1 = new FulltimeEmployee("Tom", 1000, 50);
        Employee employee2 = new ParttimeEmployee("Tony", 20, 50);
        lst.getEmployees().add(employee1);
        lst.getEmployees().add(employee2);

        FADepartment fa = new FADepartment();
        HRDepartment hr = new HRDepartment();
        lst.accept(fa);
        lst.accept(hr);
    }

}
