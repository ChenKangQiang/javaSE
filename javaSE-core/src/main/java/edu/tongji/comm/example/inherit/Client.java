package edu.tongji.comm.example.inherit;

import org.junit.Test;

/**
 * @author chenkangqiang
 * @date 2017/9/6
 */
public class Client {


    @Test
    public void test() {
        Son son = new Son();
        Father father = new Father();
        father.setName("Tom");
        father.setAge(35);

        son.setFather(father);

        /**
         * 访问到父类对象的成员属性，当父类和子类拥有相同的成员变量时，this采用就近原则
         * 若子类没有父类中的成员属性，那么this.成员属性将返回父类的成员属性
         */
        System.out.println(son.getAge());
        System.out.println(son.getName());
    }

}
