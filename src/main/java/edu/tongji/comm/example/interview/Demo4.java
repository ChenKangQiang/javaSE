package edu.tongji.comm.example.interview;

import java.util.Scanner;

/**
 * @author chenkangqiang
 * @data 2017/10/25
 */
public class Demo4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        permutation(n, array);
    }

    public static void permutation(int n, int[] array) {
        if (n == 1) {
            System.out.print("[");
            for (int i = 0; i < array.length; i++) {
                if (i == array.length - 1) {
                    System.out.print(array[i]);
                } else {
                    System.out.print(array[i] + " ");
                }

            }
            System.out.print("]");
            System.out.println();
        } else {
            for (int j = 0; j < n; j++) {
                swap(n - 1, j, array);
                permutation(n - 1, array);
                swap(n - 1, j, array);
            }
        }
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
