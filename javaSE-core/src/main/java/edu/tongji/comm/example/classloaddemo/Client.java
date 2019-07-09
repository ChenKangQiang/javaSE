package edu.tongji.comm.example.classloaddemo;

/**
 * @Author chenkangqiang
 * @Data 2017/9/17
 */
public class Client {

    public static void main(String[] args) {

        //直接调用静态方法，虚拟机会首先加载类的静态成员，但不会加载静态内部类
        //OuterClass.sayHello();

        OuterClass outer = new OuterClass();
        System.out.println("外部类静态变量加载时间=" + outer.OUTER_TIME);

        System.out.println("非静态内部类加载时间=" + outer.new InnerClass().INNER_TIME);

        //静态内部类并不是是在外部类加载是就进行初始化，而是在使用内部类时，才进行加载
        System.out.println("静态内部类加载时间=" + OuterClass.InnerStaticClass.INNER_STATIC_TIME);

    }

}
