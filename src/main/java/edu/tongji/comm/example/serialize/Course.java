package edu.tongji.comm.example.serialize;

import lombok.Getter;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-01-20
 */
public class Course {
    @Getter
    private String name;
    @Getter
    private int id;

    public Course(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
