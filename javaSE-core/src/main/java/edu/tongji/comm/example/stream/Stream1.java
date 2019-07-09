package edu.tongji.comm.example.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/10/24
 */
public class Stream1 {

    public static void main(String[] args) {
        Stream<Long> stream = Stream.of(1L, 2L, 5L, 2L);
        System.out.println(stream.collect(Collectors.toSet()));
    }

}
