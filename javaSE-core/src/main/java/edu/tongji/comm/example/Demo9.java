package edu.tongji.comm.example;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/10/26
 */
public class Demo9 {
    public static void main(String[] args) {
        List<Integer> list1 = Lists.newArrayList(1, 2, 3, 4);
        List<Integer> list2 = Lists.newArrayList(10, 11, 3, 4);
        list1.removeAll(list2);
        System.out.println(list1);


        Random random = new Random();
        int size = random.nextInt(100);

        List<Integer> list3 = Lists.newArrayList();
        for (int i = 0; i < 31; i++) {
            list3.add(i);
        }

        System.out.println(JSON.toJSONString(list3));
        System.out.println(list3.size());

        Collections.shuffle(list3, new Random(-1));
        System.out.println(JSON.toJSONString(list3));


        double a = 5D;
        System.out.println(a > 0);


        Map<String, Object> map = Maps.newHashMap();
        map.put("aaa", 578457);
        map.put("bbb", Lists.newArrayList(111111, 2222));

        int b = (int) map.get("aaa");
        List<Integer> ccc = (List<Integer>) map.get("bbb");

        System.out.println(b);
        System.out.println(ccc);


        System.out.println(getRandom(Lists.newArrayList(1, 2, 3, 4, 5, 1, 2, 1)));

        List<Integer> test = Lists.newArrayList(1, 2, 3, 4, 5, 1, 2, 1, 8, 9);

        System.out.println(test.stream().distinct().collect(Collectors.toList()));


        List<User> users = Lists.newArrayList(new User(0, "hahah"), new User(0, "ooooo"), new User(0, "jjjj"));

        users.sort(Comparator.comparingInt(User::getAge));

        System.out.println(users);


        System.out.println(new Random().nextInt(Integer.MAX_VALUE) + 1);

        System.out.println(new Random(504671).nextInt(100) + 1);
        System.out.println(new Random(504671).nextInt(3) + 1);
        System.out.println(new Random(17642397).nextInt(3) + 1);
        System.out.println(new Random(17642397).nextInt(100) + 1);
//        getRandom(0, 10, list3);
//        getRandom(1, 10, list3);
//        getRandom(2, 10, list3);
//        getRandom(3, 10, list3);
        //getRandom(4, 10, list3);


        String aaa = "56746571,56746571,";
        String[] bbb = aaa.split(",");
        for (String s : bbb) {
            System.out.println(s);
        }

    }




    public static void getRandom(int pageNum, int pageSize, List<Integer> shopIdList) {
        if (shopIdList.size() <= pageSize) {
            Collections.shuffle(shopIdList);
            System.out.println(JSON.toJSONString(shopIdList));
        } else {
            int interval = shopIdList.size() / pageSize;
            System.out.println("interval=" + interval);
            if (pageSize * pageNum > shopIdList.size()) {
                System.out.println("无数据了");
            } else {
                List<Integer> result = Lists.newArrayList();
                for (int i = pageNum; i < shopIdList.size(); i++) {
                    result.add(shopIdList.get(i));
                    i += interval;
                }
                Collections.shuffle(result);
                System.out.println(JSON.toJSONString(result));
            }
        }
    }


    public static List<Integer> getRandom(List<Integer> list) {
        Set<Integer> set = Sets.newHashSet(list);
        List<Integer> newList = Lists.newArrayList(set);
        return newList;
    }


    @AllArgsConstructor
    @Data
    private static class User {
        private int age;
        private String name;
    }




}
