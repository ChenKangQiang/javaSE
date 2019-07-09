package edu.tongji.comm.example.compare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author chenkangqiang
 * @Data 2017/9/10
 */

/**
 * 比较
 * Comparator接口
 * Comparable接口
 */
public class Client {

    @Test
    public void test() {

        List<Person> people = new ArrayList<>();
        people.add(new Person("ccc", 20));
        people.add(new Person("AAA", 30));
        people.add(new Person("bbb", 10));
        people.add(new Person("ddd", 40));

        //Person类自身实现了comparable接口，故可进行排序
        Collections.sort(people);
        System.out.println(people);

        Collections.sort(people, (person1, person2) -> person1.getAge() - person2.getAge());

        //也可以通过传入外部比较器来实现比较功能
        System.out.println(people);

    }

}
