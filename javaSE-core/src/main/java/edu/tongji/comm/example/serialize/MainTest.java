package edu.tongji.comm.example.serialize;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.SerializationUtils;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-01-20
 */
public class MainTest {

    public static void main(String[] args) {
        Course course = new Course("语文", 1);
        Student student1 = new Student("Tome", 10, course);
        Student student2 = SerializationUtils.clone(student1);
        System.out.println(student2 == student1);
        System.out.println(student2.getAge());
        System.out.println(student2.getName());
        System.out.println(student2.getCourse());
    }

}
