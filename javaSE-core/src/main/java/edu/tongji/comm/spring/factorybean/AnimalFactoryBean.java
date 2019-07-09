package edu.tongji.comm.spring.factorybean;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-04-16
 */

public class AnimalFactoryBean implements FactoryBean, InitializingBean {

    @Setter
    @Getter
    private String type;

    private Object obj;
    private Class<?> objType;

    @Override
    public Object getObject() throws Exception {
        return this.obj;
    }

    @Override
    public Class<?> getObjectType() {
        return this.objType;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }


    public void init() throws Exception {
        if (StringUtils.isEmpty(type)) {
            throw new RuntimeException();
        }
        if ("cat".equals(type)) {
            obj = new Cat();
            objType = Cat.class;
        } else if ("dog".equals(type)) {
            obj = new Dog();
            objType = Cat.class;
        }
        System.out.println("init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }


}
