package edu.tongji.comm.example;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import lombok.Data;

import java.util.Map;

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
    }


}
