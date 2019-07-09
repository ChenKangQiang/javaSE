package edu.tongji.comm.algorithm;


import java.util.Random;

/**
 * @author chenkangqiang
 * @date 2017/8/17
 * @Description 对基本的排序算法进行代码实现
 */
public class SortAlgorithm {

    public static void main(String[] args) {
        int[] array = generateArray(10);
        System.out.print("排序前=");
        printArray(array);

        //bubbleSort(array);
        //selectSort(array);
        //insertSort(array);
        //quickSort(array, 0, array.length - 1);
        mergeSort(array, 0, array.length - 1);

        System.out.print("排序后=");
        printArray(array);
    }


    /**
     * 冒泡排序
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        if (array == null || array.length <= 0) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * @param array
     */
    public static void selectSort(int[] array) {
        if (array == null || array.length <= 0) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    /**
     * 插入排序
     *
     * @param array
     */
    public static void insertSort(int[] array) {
        if (array == null || array.length <= 0) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int tmp = array[i + 1];
            int j = i;
            while (j >= 0 && array[j] > tmp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
    }

    /**
     * 快速排序
     *
     * @param array
     * @param left
     * @param right
     */
    public static void quickSort(int[] array, int left, int right) {
        if (array == null || array.length <= 0) {
            return;
        }
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;
        int x = array[i];
        while (i < j) {
            //从右向左找第一个小于x的数
            while (i < j && array[j] >= x) {
                j--;
            }
            if (i < j) {
                array[i++] = array[j];
            }

            //从左向右找第一个大于等于x的数
            while (i < j && array[i] < x) {
                i++;
            }
            if (i < j) {
                array[j--] = array[i];
            }
        }
        array[i] = x;
        //递归调用
        quickSort(array, left, i);
        quickSort(array, i + 1, right);
    }


    /**
     * @param array
     * @param left
     * @param right
     */
    public static void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        //二路归并排序里面有两个Sort，多路归并排序里面写多个Sort就可以了
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        //temp数组用于暂存合并的结果
        int[] tmp = new int[right - left + 1];
        //左半边的指针
        int i = left;
        //右半边的指针
        int j = mid + 1;
        //合并后数组的指针
        int k = 0;

        //将记录由小到大地放进temp数组
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
            }
        }

        //接下来两个while循环是为了将剩余的（比另一边多出来的个数）放到temp数组中
        while (i <= mid) {
            tmp[k++] = array[i++];
        }
        while (j <= right) {
            tmp[k++] = array[j++];
        }

        //将temp数组中的元素写入到待排数组中
        for (int l = 0; l < tmp.length; l++)
            array[left + l] = tmp[l];
    }


    public static void printArray(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                stringBuilder.append(array[i]).append("]");
                continue;
            }
            stringBuilder.append(array[i]).append(",");
        }
        System.out.println(stringBuilder.toString());
    }

    public static int[] generateArray(int size) {
        if (size <= 0) {
            return null;
        }
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


}
