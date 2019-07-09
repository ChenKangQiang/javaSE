package edu.tongji.comm;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/8/2
 */
public class Demo3 {

    public static void main(String[] args) {

        Map<Long, String> longStringMap = Maps.newHashMap();
        longStringMap.put(100L, "hello");
        Integer aaaaaa = 100;
        System.out.println(longStringMap.get(aaaaaa));

        Map<Integer, Integer> linkedHashMap = Maps.newLinkedHashMap();
        linkedHashMap.put(1, 10);
        linkedHashMap.put(4, 0);
        linkedHashMap.put(2, 23);
        linkedHashMap.put(9, 3);

        System.out.println(linkedHashMap.values());

        List<Integer> list1 = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        System.out.println("list1: " + list1);
        dealList1(list1);
        System.out.println("after deal list1: " + list1);


        List<Integer> list2 = Lists.newArrayList(100, 200, 300);
        System.out.println("list1: " + list2);
        dealList1(list1);
        System.out.println("after deal list1: " + list2);


        Integer[] array = new Integer[]{1, 2};
        Integer a = array[1];
        array[1] = null;
        System.out.println(a);

        JSON.toJSONString(null);
        Integer aaa = JSON.parseObject(null, Integer.class);


        double result1=0.51111122111111;
        DecimalFormat df = new DecimalFormat("0%");
        String r = df.format(result1);
        System.out.println(r);//great

        System.out.println(new DecimalFormat("0%").format(0));

        System.out.println("“" + "hello" + "”");
        System.out.println("hello");

        Set<Integer> set = Sets.newHashSet(111, 2222);
        System.out.println(set.contains(null));

        BigDecimal bigDecimal = new BigDecimal("189.00");
        System.out.println(bigDecimal.stripTrailingZeros().toPlainString());

        Double ccc = 40.0;
        System.out.println(ccc >= 40);


        int test1 = 100;
        int test2 = 200;

        String reason = "";
        if (test1 >= 50) {
            reason = "test1";
        } else if (test2 >= 50) {
            reason = "test2";
        }

        System.out.println(reason);


        System.out.println(String.format("“%s”", "hello"));


        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 9, 1, 1, 1,1,1,1,1,1,1);
        List<String> listb = Lists.newArrayList("1", "1", "1", "1","1","1");
        list = limitList(list);
        listb = limitList(listb);
        System.out.println(JSON.toJSONString(list));
        System.out.println(JSON.toJSONString(listb));

        Map<Integer, Integer> map1 = Maps.newHashMap();
        map1.put(1, 2);
        map1.put(2, 2);
        map1.put(3, 2);
        map1.put(4, 2);
        map1.put(5, 2);

        System.out.println(map1);
        test(map1);
        test(map1);
        System.out.println(map1);

        System.out.println("");

//        map1 = limitMap(map1);
//        System.out.println(JSON.toJSONString(map1));
//
//        Map<Integer, String> map2 = Maps.newHashMap();
//        map2.put(1, "3");
//        map2.put(2, "3");
//        map2.put(3, "3");
//        map2.put(4, "3");
//        map2.put(5, "3");
//
//        map2 = limitMap(map2);
//        System.out.println(JSON.toJSONString(map2));

        Map<Integer, String> testMap2 = Maps.newHashMap();
        Type type = testMap2.getClass().getGenericSuperclass();
        System.out.println(type);
//        ParameterizedType p = (ParameterizedType) type;
//        //getActualTypeArguments获取参数化类型的数组，泛型可能有多个
//        Class c = p.getActualTypeArguments()[0].getClass();
//        System.out.println(c);

        double ccccc = 100.0D;

        Map<Set<Integer>, Set<Integer>> testMap = Maps.newHashMap();
        testMap.put(Sets.newHashSet(1), Sets.newHashSet(2));
        testMap.put(Sets.newHashSet(1), Sets.newHashSet(3));
        System.out.println(JSON.toJSONString(testMap));

        System.out.println(Boolean.FALSE + "");


    }


    public static void dealList1(List<Integer> list) {
        list = Lists.newArrayList(7, 8, 9, 10);
    }



    public static void dealList2(List<Integer> list) {
        list.add(800);
    }




    public static <T> List<T> limitList(List<T> original) {
        if (CollectionUtils.isEmpty(original)) {
            return Collections.emptyList();
        }
        if (original.size() > 3) {
            List<T> target = Lists.newArrayList();
            target.addAll(original.subList(0, 3));
            return target;
        } else {
            return original;
        }
    }


    public static <K, V> Map<K, V> limitMap(Map<K, V> original) {
        Map<K, V> target = Maps.newHashMap();
        if (MapUtils.isEmpty(original)) {
            return target;
        }
        if (original.size() > 3) {
            original.entrySet()
                    .stream()
                    .limit(3)
                    .forEach(entry -> target.put(entry.getKey(), entry.getValue()));
            return target;
        } else {
            return original;
        }
    }



    public static <K, V> void test(Map<K, V> original) {
        original = limitMap(original);
        System.out.println(original);
    }






}
