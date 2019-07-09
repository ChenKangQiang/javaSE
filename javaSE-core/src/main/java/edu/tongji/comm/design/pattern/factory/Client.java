package edu.tongji.comm.design.pattern.factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"src/main/resources/application-context.xml"})
public class Client {

    @Test
    public void test() {
        SkinFactory skinFactory = new SpringSkinFactory();
        skinFactory.createButton().display();
        skinFactory.createTextField().display();
        skinFactory.createComboBox().display();
        skinFactory.createCheckBox().display();
    }

}
