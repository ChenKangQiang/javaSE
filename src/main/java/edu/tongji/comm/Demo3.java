package edu.tongji.comm;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/8/2
 */
public class Demo3 {

    public static void main(String[] args) {

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
    }


    public static void dealList1(List<Integer> list) {
        list = Lists.newArrayList(7, 8, 9, 10);
    }



    public static void dealList2(List<Integer> list) {
        list.add(800);
    }


}
