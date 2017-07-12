package edu.tongji.comm.javase.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by chen on 2017/7/12.
 *
 * 代理类需要有一个调用处理器 InvocationHandler
 */

public class MyInvocationProxy implements InvocationHandler {

    // 被代理对象
    private Object subject;

    // 构造方法出入被代理对象，要代理谁就传入谁
    public MyInvocationProxy(Object subject) {
        this.subject = subject;
    }

    /**
     *
     * @param object: 生成的代理对象
     * @param method: 所要调用的被代理对象的方法
     * @param args: 调用被代理对象方法时的输入参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object object, Method method, Object[] args) throws Throwable {

        // 在调用被代理对象本身的方法前，我们可以添加一些自己的操作
        System.out.println("before rent house");

        System.out.println("Method:" + method);

        // 调用被代理对象本身的方法
        method.invoke(subject, args);

        // 在调用被代理对象本身的方法后，我们可以添加一些自己的操作
        System.out.println("after rent house");

        return null;
    }
}
