package edu.tongji.comm.javase.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import edu.tongji.comm.javase.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chen on 2017/7/14.
 */
public class JsonTest {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setUserID(i);
            user.setUsername("Tom");
            user.setPassword("123456");
            users.add(user);
        }

        System.out.println(JSONObject.toJSONString(users));

        List<Integer> list1 = new ArrayList<>(Arrays.asList(10, 9, 8, 7, 5));
        List<Integer> list2 = Lists.newArrayList();
        list2 = Lists.newArrayList();
        list2 = new ArrayList<>();

        System.out.println(JSON.toJSONString(method(list1, 2)));
        System.out.println(JSON.toJSONString(method(list2, 2)));
    }


    public static List<Integer> method(List<Integer> list, int type) {
        if (type == 2) {
            list.clear();
            for (int i = 0; i < 10; i++) {
                list.add(i);
            }
        }
        return list;
    }

}





