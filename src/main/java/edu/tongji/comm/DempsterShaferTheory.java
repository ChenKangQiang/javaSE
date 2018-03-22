package edu.tongji.comm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenkangqiang
 * @data 2018/1/3
 *
 * D-S证据理论计算
 */
public class DempsterShaferTheory {


    public static void main(String[] args) {

        List<double[]> listPBA = new ArrayList<>();

        double[] doubles1 = {0, 0.9, 0.1};
        double[] doubles2 = {0.6, 0, 0.4};
        double[] doubles3 = {0.6, 0, 0.4};
//        double[] doubles4 = {0, 0.8, 0.2};
        listPBA.add(doubles1);
        listPBA.add(doubles2);
        listPBA.add(doubles3);
//        listPBA.add(doubles4);

        double[] result = combineMass(listPBA);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }


    /**
     * 证据合成
     * @param listPBA
     * @return
     */
    public static double[] combineMass(List<double[]> listPBA) {
        double[] result = new double[3];
        for (int i = 0; i < result.length; i++) {
            result[i] = listPBA.get(0)[i];
        }

        for (int i = 1; i < listPBA.size(); i++) {
            double a = result[0];
            double b = result[1];
            double c = result[2];
            double k = a * listPBA.get(i)[0] + a * listPBA.get(i)[2]
                    + b * listPBA.get(i)[1] + b * listPBA.get(i)[2]
                    + c * listPBA.get(i)[0] + c * listPBA.get(i)[1] + c * listPBA.get(i)[2];

            System.out.println("k=" + k);

            result[0] = (result[0] * listPBA.get(i)[0] + result[0] * listPBA.get(i)[2]
                    + result[2] * listPBA.get(i)[0]) / k;

            result[1] = (result[1] * listPBA.get(i)[1] + result[1] * listPBA.get(i)[2]
                    + result[2] * listPBA.get(i)[1]) / k;

            result[2] = (result[2] * listPBA.get(i)[2]) / k;

        }

        return result;
    }



}
