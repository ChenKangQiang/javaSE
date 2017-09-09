package edu.tongji.comm.example.bean;

/**
 * @author chenkangqiang
 * @date 2017/9/5
 */
public class TestBean {

    public TestBean() {
        System.out.println("构造对象");
    }

    /**
     * spring初始化bean后所执行的操作
     */
    public void init() {
        System.out.println("对象构造后执行一些操作");
    }

    /**
     * spring销毁容器前所执行的操作
     */
    public void destroy() {
        System.out.println("spring容器销毁前，bean实例执行一些操作");
    }


}
