package edu.tongji.comm.design.pattern.singleton;

/**
 * @author chenkangqiang
 * @date 2017/8/29
 * @Description
 */
public enum  LazySingletonWithEnum {

    //enum成员默认是public static final
    INSTANCE;

    //其实不需要getInstance()，直接用LazySingletonWithEnum.INSTANCE就可以获取到
    public LazySingletonWithEnum getInstance() {
        return INSTANCE;
    }

    /**
     * 可以添加字段属性
     */
}
