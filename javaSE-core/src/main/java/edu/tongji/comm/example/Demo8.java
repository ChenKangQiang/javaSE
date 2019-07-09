package edu.tongji.comm.example;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/10/23
 */
public class Demo8 {

    public static void main(String[] args) {
        List<List<Set<Integer>>> filters = build();

        for (List<Set<Integer>> item : filters) {
            System.out.println(item);
        }

        int maxLen = 0;
        int index = 0;
        for (int i = 0; i < filters.size(); i++) {
            if (filters.get(i).size() > maxLen) {
                maxLen = filters.get(i).size();
                index = i;
            }
        }

        for (int i = 0; i < filters.size(); i++) {
            if (i == index) {
                continue;
            } else {
               int curentSize = maxLen - filters.get(i).size() + 1;
               for (int j = 0; j < curentSize; j++) {
                   for (int k = j; k < curentSize; k++) {

                   }
               }
            }
        }

        System.out.println("maxLen=" + maxLen);
        System.out.println("index=" + index);

    }



    public static List<List<Set<Integer>>> build() {
        Random random1 = new Random();
        Random random2 = new Random();
        Random random3 = new Random();

        List<List<Set<Integer>>> result = Lists.newArrayList();

        int a = random1.nextInt(5) + 1;
        //System.out.println("a=" + a);
        for (int i = 0; i < a; i++) {
            List<Set<Integer>> setList = Lists.newArrayList();
            int b = random2.nextInt(5) + 1;
            //System.out.println("b=" + b);
            for (int j = 0; j < b; j++) {
                Set<Integer> set = Sets.newHashSet();
                int c = random3.nextInt(5) + 1;
                //System.out.println("c=" + c);
                for (int k = 0; k < c; k++) {
                    set.add(random3.nextInt(100));
                }
                setList.add(set);
            }
            result.add(setList);
        }
        return result;
    }


}
