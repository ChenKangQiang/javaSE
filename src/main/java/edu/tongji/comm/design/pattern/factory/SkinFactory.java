package edu.tongji.comm.design.pattern.factory;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description
 */

/**
 * 抽象工厂
 */
public interface SkinFactory {
    Button createButton();
    TextField createTextField();
    ComboBox createComboBox();

    /**
     * 存在开闭原则的倾斜性，即增加一个新的产品族时，需要修改接口即具体实现类
     * 若不想修改具体实现类，可在接口中增加default方法
     */
    default CheckBox createCheckBox() {
        if (this.getClass().getName().contains("Spring")) {
            return new SpringCheckBox();
        }
        return new SummerCheckBox();
    }
}
