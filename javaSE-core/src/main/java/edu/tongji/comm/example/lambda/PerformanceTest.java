package edu.tongji.comm.example.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @Author chenkangqiang
 * @Data 2017/9/17
 */
public class PerformanceTest {


//    private static final List<Integer> TEST_DATA = new ArrayList<>();
//
//    static {
//        Random random = new Random();
//        for (int i = 0; i < 10000000; i++) {
//            TEST_DATA.add(random.nextInt(10000000));
//        }
//    }


    public static void main(String[] args) {

//        long sum = 0l;
//
//        long start1 = System.currentTimeMillis();
//        System.out.println(start1);
//        for (Integer i : TEST_DATA) {
//            sum += i;
//        }
//        long end1 = System.currentTimeMillis();
//        System.out.println(end1 - start1);
//
//
//        long start2 = System.currentTimeMillis();
//        System.out.println(start2);
//        //使用并行流，自动包装导致结果stream的性能受到影响
//        TEST_DATA.parallelStream().reduce(0, (a, b) -> a + b);
//        long end2 = System.currentTimeMillis();
//        System.out.println(end2 - start2);



        int[] a = new Random().ints(100000000, 1, 99999999).toArray();
        int e = a.length;
        int m = Integer.MIN_VALUE;

        long thisTime = System.currentTimeMillis();
        for (int i = 0; i < e; i++)
            if (a[i] > m) m = a[i];
        System.out.println("MAX is " + m);
        Long testRes = System.currentTimeMillis() - thisTime;
        System.out.println("For use time :" + testRes);

        System.out.println(IntStream.of(a).toArray().length);
        thisTime = System.currentTimeMillis();
        //防止自动装箱
        //m = IntStream.of(a).reduce(0, (x, y) -> x > y ? x : y);
        //m = Arrays.stream(a).reduce(0, (x, y) -> x > y ? x : y);

        //采用并行
        m = Arrays.stream(a).parallel().reduce(0, (x, y) -> x > y ? x : y);
        System.out.println("MAX is " + m);
        testRes = System.currentTimeMillis() - thisTime;
        System.out.println("StreamSimple use time :" + testRes);
    }


}
