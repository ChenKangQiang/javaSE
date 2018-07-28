package edu.tongji.comm.example.collections;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/7/23
 */
public class Demo {

    public static void main(String[] args) {
        Set<Integer> set1 = Sets.newHashSet();
        set1.add(1);
        set1.add(2);
        set1.add(5);
        set1.add(8);

        Set<Integer> set2 = Sets.newHashSet();
        set2.add(2);
        set2.add(5);
        set2.add(10);

        set1.removeAll(set2);
        System.out.println(set1);

        System.out.println(getResult(1));

        String aaa = "春季\n周二至周日\n早市 07:00-09:00\n午市 11:30-14:00\n\n周一\n早市 07:00-09:00\n早午餐 10:00-14:00\n午市 11:30-14:00\n下午茶 14:00-16:00\n晚市 17:30-21:00\n夜宵 22:00-01:00\n\n夏季\n周一至周日\n早市 07:00-09:00\n午市 11:30-14:00\n夜宵 22:00-01:00\n\n秋季、冬季\n周一至周日\n早市 07:00-09:00\n午市 11:30-14:00\n\n非营业时段\n2018-07-01至2018-07-02 18:00-18:30\n2018-07-11至2018-07-12 18:00-18:30";
        System.out.println(aaa);

        System.out.println(aaa.split("\n\n").length);

        List<Integer> list1 = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(Lists.partition(list1, 20));

    }


    public static Set<Integer> getResult(int type) {
        if (type == 1) {
            return Sets.newHashSet();
        } else {
            return null;
        }
    }

    interface A {
        default void getAAA() {
            this.getClass().getSimpleName();
        }
    }

}
