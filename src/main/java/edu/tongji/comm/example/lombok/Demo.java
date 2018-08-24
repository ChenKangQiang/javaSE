package edu.tongji.comm.example.lombok;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/8/23
 */
public class Demo {


    public static void main(String[] args) {
        User user1 = new User("Tom", 20, Lists.newArrayList(1, 2, 3));
        User user2 = new User("Tom", 20, Lists.newArrayList(1, 2, 3));
        System.out.println(user1.equals(user2));

    }


    @Data
    @AllArgsConstructor
    private static class User {
        private String name;
        private Integer age;
        private List<Integer> shopIds;
    }


}
