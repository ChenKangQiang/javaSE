package edu.tongji.comm.example.interview;

import java.util.Scanner;

/**
 * @Author chenkangqiang
 * @Data 2017/9/9
 */
public class Demo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int arrayNumber = scanner.nextInt();
        System.out.println(arrayNumber);

        int index = 1;
        while(index <= arrayNumber) {
            int length = scanner.nextInt();
            int[] array = new int[length];
            for (int i = 0; i < length; i++) {
                array[i] = scanner.nextInt();
            }
            System.out.println(fun(array));
            index++;
        }
    }


    public static boolean fun(int[] array) {
        boolean flag = false;
        int oddCount = 0;
        int fourCount = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] / 2 == 1) {
                oddCount++;
            } else if (array[i] / 4 == 0) {
                fourCount++;
            }
        }

        if ((array.length / 2 == 0 && fourCount >= oddCount) || (array.length / 2 == 1 && fourCount >= oddCount - 1)) {
            flag = true;
        }

        return flag;
    }



}
