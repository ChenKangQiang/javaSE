package edu.tongji.comm.design.pattern.factory;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description
 */
public class SummerSkinFactory implements SkinFactory {

    @Override
    public Button createButton() {
        return new SummerButton();
    }

    @Override
    public TextField createTextField() {
        return new SummerTextField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SummerComboBox();
    }
}
