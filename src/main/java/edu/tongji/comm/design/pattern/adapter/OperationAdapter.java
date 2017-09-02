package edu.tongji.comm.design.pattern.adapter;

/**
 * @author chenkangqiang
 * @date 2017/8/31
 * @Description
 */

/**
 * 适配器
 */
public class OperationAdapter implements ScoreOperation {

    @Override
    public int[] sort(int[] array) {
        return new int[0];
    }

    @Override
    public int search(int[] array, int key) {
        return 0;
    }
}
