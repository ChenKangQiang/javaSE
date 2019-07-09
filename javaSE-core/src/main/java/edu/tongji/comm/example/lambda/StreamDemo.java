package edu.tongji.comm.example.lambda;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/7/27
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<List<Map<Integer, String>>> listList = Lists.newArrayList();
        Map<Integer, String> map1 = Maps.newHashMap();
        map1.put(1, "hello");

        List<Map<Integer, String>> list1 = Lists.newArrayList();
        listList.add(list1);
        listList.get(0).add(map1);
        listList.get(0).add(map1);

        List<List<List<JSONObject>>> result = listList.stream().map(
            list -> list.stream().map(
                    item -> item.entrySet().stream().map(
                            entry -> {
                                JSONObject jsonObject = new JSONObject();
                                jsonObject.put(entry.getKey().getClass().getSimpleName(), entry.getValue());
                                return jsonObject;
                            }).collect(Collectors.toList()))
                    .collect(Collectors.toList()))
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue));

        int[] a = new int[]{1, 2, 3, 4};
        System.out.println(JSON.toJSONString(a));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("listlist", listList);
        jsonObject.put("a", a);
        System.out.println(JSON.toJSONString(jsonObject, SerializerFeature.WriteMapNullValue));

    }

}
