package edu.tongji.comm.example.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author chenkangqiang
 * @Data 2017/10/17
 */
public class Demo3 {


    public static void main(String[] args) {
        List<Integer> prices1 = Arrays.asList(7, 1, 5, 3, 6, 4, 9);
        List<Integer> prices2 = Arrays.asList(7, 1, 5, 3, 6, 4, 9, 2, 10);
        System.out.println(maxProfit_N(prices1));

        System.out.println(maxProfit_1(prices1));

        System.out.println(maxProfit_2(prices1));
    }




    public static int maxProfit_N(List<Integer> prices) {
        List<Integer> profitList = getProfitList(prices);

        int profit = 0;
        for (Integer i : profitList) {
            profit += i;
        }
        return profit;
    }

    public static int maxProfit_1(List<Integer> prices) {
        return getProfitList(prices).get(0);
    }


    public static int maxProfit_2(List<Integer> prices) {
        List<Integer> profitList = getProfitList(prices);

        if (profitList.size() <= 0) {
            return 0;
        } else if (profitList.size() < 2) {
            return profitList.get(0);
        } else {
            return profitList.get(0) + profitList.get(1);
        }

    }


    public static List<Integer> getProfitList(List<Integer> prices) {
        Integer[] priceArray = (Integer[])prices.toArray();
        List<Integer> profitList = new ArrayList<>();

        int i = 0;
        while (i < priceArray.length) {
            int temp = priceArray[i];
            int j = i;
            while (j < priceArray.length - 1) {
                if (priceArray[j + 1] >= priceArray[j]) {
                    j++;
                    if (priceArray[j] - temp > 0) {
                        profitList.add(priceArray[j] - temp);
                        break;
                    }
                } else {
                    if (priceArray[j] - temp > 0) {
                        profitList.add(priceArray[j] - temp);
                    }
                    break;
                }
            }
            i = j + 1;
        }

        profitList.sort(Comparator.reverseOrder());

        return profitList;

    }


}
