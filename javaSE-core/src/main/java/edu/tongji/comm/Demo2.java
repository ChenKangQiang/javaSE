package edu.tongji.comm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author chenkangqiang
 * @data 2018/3/22
 */
public class Demo2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] a = str.split("");
        int[] b = new int[a.length];
        int[] counts = new int[10];
        for (int i = 0; i < a.length; i++) {
            b[i] = Integer.parseInt(a[i]);
            counts[b[i]]++;
        }

//        for (int i = 0; i < counts.length; i++) {
//            System.out.println(counts[i]);
//        }

        List<Integer> integerList = new ArrayList<>();

        for (int i = 1; i < counts.length; i++) {
            if (counts[i] == 0) {
                integerList.add(i);
                break;
            } else if (i == 9) {
                integerList.add(1);
                counts[1]--;
                break;
            }
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) {
                integerList.add(i);
                break;
            } else if (i == 9) {
                integerList.add(0);
                counts[0]--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < integerList.size(); i++) {
            sb.append(integerList.get(i));
        }

        System.out.println(sb.toString());

    }

}
