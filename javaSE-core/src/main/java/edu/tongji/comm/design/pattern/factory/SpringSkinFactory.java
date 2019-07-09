package edu.tongji.comm.design.pattern.factory;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description
 */
public class SpringSkinFactory implements SkinFactory {

    @Override
    public Button createButton() {
        return new SpringButton();
    }

    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}
