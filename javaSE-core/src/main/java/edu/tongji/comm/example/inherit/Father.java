package edu.tongji.comm.example.inherit;

import lombok.Data;

/**
 * @author chenkangqiang
 * @date 2017/9/6
 */

public class Father {

    private String name;
    private int age;

    public void setFather(Father father) {
        this.name = father.getName();
        this.age = father.getAge();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }



}
