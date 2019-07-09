package edu.tongji.comm.design.pattern.visitor.example;

/**
 * @Author chenkangqiang
 * @Data 2017/9/2
 * @Description
 */

/**
 * 财务部门类，具体的访问类，通过重载方法，可以调用相应元素的方法
 */
public class FADepartment extends Department {
    @Override
    public void visit(FulltimeEmployee employee) {
        int workTime = employee.getWorkTime();
        double weekWage = employee.getWeeklyWage();
        //全职员工加班，每小时100元
        if (workTime > 40) {
            weekWage = weekWage + (workTime - 40) * 100;
        } else if (workTime < 40) {
            weekWage = weekWage - (40 - workTime) * 80;
            if (weekWage < 0) {
                weekWage = 0;
            }
        }
        System.out.println("正式员工" + employee.getName() + " 实际工资为：" + weekWage + "元");
    }

    @Override
    public void visit(ParttimeEmployee employee) {
        int workTime = employee.getWorkTime();
        double hourWage = employee.getHourWage();
        System.out.println("临时工" + employee.getName() + " 实际工资为：" + workTime * hourWage + "元");
    }
}
