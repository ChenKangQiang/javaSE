package edu.tongji.comm.example.compare;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author chenkangqiang
 * @Data 2017/9/10
 */

@Data
@AllArgsConstructor
public class Person implements Comparable<Person> {
    private String name;
    private int age;

    @Override
    public int compareTo(Person person) {
        return name.compareTo(person.name);
    }

}
