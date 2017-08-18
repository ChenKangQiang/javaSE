package edu.tongji.comm.example.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by chen on 2017/7/12.
 */
public class Client {

    public static void main(String[] args) {

        // 被代理对象
        Subject realSubject = new RealSubject();

        // 将被代理对象传入
        InvocationHandler handler = new MyInvocationProxy(realSubject);

        /*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看这三个参数
         * 第一个参数需传入类加载器，可以使用被代理对象的类加载器，即 realSubject.getClass().getClassLoader()
         * 第二个参数被代理对象的接口方法，即 realSubject.getClass().getInterfaces()，这样可以让代理知道实现哪些接口
         * 第三个参数invocationHandler
         */

        // 生成代理，可以看到，代理实现了真实对象的接口方法
        Subject subject = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject
                .getClass().getInterfaces(), handler);

        System.out.println(subject.getClass().getName());

        subject.rent();

        subject.hello("world");
    }
}
