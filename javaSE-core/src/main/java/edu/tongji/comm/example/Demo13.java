package edu.tongji.comm.example;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-01-01
 */
@Data
public class Demo13 {

    private Map<Integer, String> map;
    private String age;


    public static void main(String[] args) {
        Demo13 object1 = new Demo13();
        Demo13 object2 = new Demo13();
        Map<Integer, String> map = Maps.newHashMap();
        map.put(1, "hello");
        object1.setMap(map);
        object2.setAge(object1.getAge());
        object2.setMap(object1.getMap());
        System.out.println(object2.getMap());
        object1.getMap().put(2, "world");
        System.out.println(object2.getMap());

        Map<String, String> testMap = Maps.newHashMap();
        testMap.put("hello", "world");

        testMap.remove("222");
        testMap.remove("4444");

        System.out.println(JSON.toJSONString(testMap));

        System.out.println(CollectionUtils.containsAny(Sets.newHashSet(), Sets.newHashSet()));

        System.out.println(JSON.toJSONString(new Class[]{Integer.class, int.class}));

        System.out.println(String.format("入参%s", new Object()));

        Set<Integer> set = Sets.newHashSet();

        set.addAll(Sets.newHashSet(Sets.difference(Sets.newHashSet(), Sets.newHashSet())));

        System.out.println(Demo13.class.getSimpleName());

    }


}
