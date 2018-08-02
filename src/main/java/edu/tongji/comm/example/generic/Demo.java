package edu.tongji.comm.example.generic;

import com.google.common.collect.Maps;
import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/7/25
 */
public class Demo {

    public static void main(String[] args) {

        Object obj = new HashMap<Integer, String>();
        ((HashMap) obj).put(1, "hello");

        Map<Integer, Object> obj2 = (Map<Integer, Object>) obj;

        Object obj3 = obj2;

        Map<Integer, String> obj4 = (Map<Integer, String>) obj3;

        System.out.println(obj4.get(1));

    }


    public static void test() {

    }


    public static <T> Map<Integer, Object> transformPigeonResult(Map<Integer, T> pigeonResult) {
        Map<Integer, Object> result = Maps.newHashMap();
        if (MapUtils.isNotEmpty(pigeonResult)) {
            for (Map.Entry<Integer, T> entry : pigeonResult.entrySet()) {
                if (entry != null) {
                    result.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return result;
    }

    public static <T> Map<Integer, T> transformPigeonResult(Object pigeonResult) {
        return (Map<Integer, T>) pigeonResult;
    }


}
