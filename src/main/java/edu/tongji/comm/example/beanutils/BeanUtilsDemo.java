package edu.tongji.comm.example.beanutils;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/10/23
 */
public class BeanUtilsDemo {


    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(20);
        student.setName("Tom");
        student.setNickName("Tony");
        student.setFace(100);

        User user = new User();
        BeanUtils.copyProperties(student, user);
        System.out.println(JSON.toJSONString(user));
        Futures.successfulAsList();

        Student student1 = new Student();
        BeanUtils.copyProperties(student, student1);
        student1.setNickName("Mary");
        System.out.println(student1);
    }



    @Data
    private static class Student {
        private String name;
        private long age;
        private String nickName;
        private long face;
    }


    @Data
    private static class User {
        private String name;
        private long age;
        private String face;
    }


}
