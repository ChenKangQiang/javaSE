package edu.tongji.comm.example.reflect;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/7/30
 */
public class ReflectDemo {

    public static void main(String[] args) {
        ReflectDemo reflectDemo = new ReflectDemo();
        reflectDemo.test1();
        reflectDemo.test2();

    }


    public void test1() {
        try {
            Method sayMethod = ReflectBean.class.getDeclaredMethod("say", new Class[]{Integer.class, String.class});
            sayMethod.setAccessible(true);
            sayMethod.invoke(ReflectBean.class.newInstance(), new Object[]{1, "hello"});
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void test2() {
        try {
            Method sayMethod = ReflectBean.class.getDeclaredMethod("show", new Class[]{int.class, String.class, int.class});
            sayMethod.setAccessible(true);
            sayMethod.invoke(ReflectBean.class.newInstance(), new Object[]{1, "hello", 3});
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
