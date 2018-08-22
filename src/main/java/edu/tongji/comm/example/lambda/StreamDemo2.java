package edu.tongji.comm.example.lambda;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/8/21
 */
public class StreamDemo2 {

    public static void main(String[] args) {
        List<List<Set<User>>> listList = Lists.newArrayList();
        User user1 = new User("Tom", 10);
        User user2 = new User("Jack", 20);
        Set<User> set1 = Sets.newHashSet(user1, user2);
        List<Set<User>> list1 = Lists.newArrayList();
        list1.add(set1);
        listList.add(list1);
        listList.add(list1);

        System.out.println(listList.size());
        System.out.println(listList.get(0).get(0));

//        List<List<Map<User, Object>>> result = listList.stream().map(
//                list -> list.stream().map(
//                        set -> set.stream().collect(HashMap::new, (m, v)->
//                                m.put(m, null), HashMap::putAll))
//                        .collect(Collectors.toList())).collect(Collectors.toList());

        List<List<Map<User, Object>>> result2 = listList.stream().map(
                list -> list.stream().map(
                        set -> {
                            Map<User, Object> users = Maps.newHashMap();
                            set.stream().forEach(user -> users.put(user, null));
                            return users;
                        }).collect(Collectors.toList())).collect(Collectors.toList());

//                List<List<Map<String, String>>> result = listList.stream().map(
//                list -> list.stream().map(
//                        set -> set.stream().collect(HashMap::new, (m, v)->
//                                m.put(v.getName(), v.getAge()), HashMap::putAll))
//                        .collect(Collectors.toList())).collect(Collectors.toList());



        System.out.println(result2.size());
        System.out.println(result2.get(0).get(0).get(user1));

    }



    @Data
    @AllArgsConstructor
    private static class User {
        private String name;
        private int age;
    }

}
