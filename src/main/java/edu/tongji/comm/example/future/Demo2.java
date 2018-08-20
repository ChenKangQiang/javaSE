package edu.tongji.comm.example.future;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/8/15
 */
public class Demo2 {


    public static void main(String[] args) {
        Map<Integer, Boolean> map = Maps.newHashMap();
        map.put(1, true);

        System.out.println(Boolean.TRUE.equals(map.get(2)));


        List<List<Map<Integer, String>>> aaa = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(aaa)) {
            for (List<Map<Integer, String>> list : aaa) {
                for (Map<Integer, String> stringMap : list) {
                    System.out.println(1);
                    stringMap.get(1);
                }
            }
        }


        Map<Integer, String> map1 = Maps.newHashMap();
        map1.put(1, null);
        map1.put(2, "hello");
        System.out.println(map1.get(3) == null);
        System.out.println(map1.get(1) == null);
    }


}
