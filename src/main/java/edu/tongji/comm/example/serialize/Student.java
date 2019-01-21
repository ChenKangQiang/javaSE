package edu.tongji.comm.example.serialize;

import lombok.Getter;

import java.io.Serializable;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-01-20
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 90313521930524818L;
    @Getter
    private String name;
    @Getter
    private int age;

    @Getter
    private Course course;

    public Student(String name, int age, Course course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }
}
