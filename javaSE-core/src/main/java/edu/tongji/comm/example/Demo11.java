package edu.tongji.comm.example;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018-12-18
 */
public class Demo11 {

    public static void main(String[] args) {
        Map<Integer, Object> result1 = Maps.newHashMap();
        result1.put(1, null);
        result1.put(2, "asd");
        Map<Integer, List<Object>> result2 = Maps.newHashMap();
        Object temp = result1;
        result2 = (Map<Integer, List<Object>>) temp;
        result2.put(1, Lists.newArrayList(1, 2, 3));
        System.out.println(result2.get(1));
        result2.put(2, Lists.newArrayList(4, 5, 6));
        System.out.println(result2.get(2));
        System.out.println(Collections.EMPTY_LIST.equals(null));

        LinkedHashSet<Integer> linkedHashSet = Sets.newLinkedHashSet();
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(3);
        System.out.println(linkedHashSet);

        Set<Integer> bbb = (Set<Integer>) linkedHashSet;

        System.out.println(bbb);

        Map<Integer, Integer> map1 = Maps.newHashMap();
        Map<Integer, Integer> map2 = Maps.newHashMap();

        Set<Integer> integerSet1 = Sets.newHashSet(map1.keySet());
        Set<Integer> integerSet2 = Sets.newHashSet(map1.keySet());

        System.out.println(Sets.difference(integerSet1, integerSet2));

        Date now = new Date();
        System.out.println(now.getTime());
        System.out.println(JSON.toJSONString(now));

        System.out.println(Boolean.TRUE.equals(new Boolean(false)));
        System.out.println(Boolean.TRUE.equals(new Boolean(true)));
        System.out.println(Boolean.TRUE.equals(null));


        List<Integer> list1 = Lists.newArrayList(1, 2, 3, 4, 5, 6, 6, 7, 8);
        List<Integer> list2 = Lists.newArrayList(1, 6, 7);
        list1.removeAll(list2);
        System.out.println(JSON.toJSONString(list1));


        String aaaa = "hhh";
        String bbbb = "hhh";
        Set<String> stringSet = Sets.newHashSet();
        stringSet.add(aaaa);
        stringSet.add("hhh");
        System.out.println(stringSet.size());


        AtomicInteger atomicInteger1 = new AtomicInteger(Integer.MAX_VALUE);
        AtomicInteger atomicInteger2 = new AtomicInteger(Integer.MIN_VALUE);

        System.out.println(atomicInteger1.incrementAndGet());
        System.out.println(atomicInteger2.decrementAndGet());

        List<Integer> list = Lists.newArrayList();
        Map<Integer, Integer> map = Maps.newHashMap();
        list.removeAll(map.keySet());
        System.out.println(list);

        System.out.println(Boolean.TRUE.equals(null));

        Set<Integer> integerSet = Sets.newHashSet();
        integerSet.addAll(Collections.emptySet());
        System.out.println(integerSet.size());

        System.out.println(String.valueOf(new Integer(100)));

        System.out.println(TimeUnit.MILLISECONDS.toNanos(100));
        System.out.println(TimeUnit.MILLISECONDS.toSeconds(1000));
    }

}
