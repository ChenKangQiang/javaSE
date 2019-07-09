package edu.tongji.comm.spring.factorybean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-04-17
 */
public class ToolFactory implements FactoryBean<Tool> {

    @Setter
    @Getter
    private int factoryId;

    @Setter
    @Getter
    private int toolId;

    @Override
    public Tool getObject() throws Exception {
        return new Tool(toolId);
    }

    @Override
    public Class<?> getObjectType() {
        return Tool.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
