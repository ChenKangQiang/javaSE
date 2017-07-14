package edu.tongji.comm.javase.json;

import com.alibaba.fastjson.JSONObject;
import edu.tongji.comm.javase.entity.User;

import java.util.ArrayList;
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
    }

}





