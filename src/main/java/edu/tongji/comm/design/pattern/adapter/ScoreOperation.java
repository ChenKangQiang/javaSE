package edu.tongji.comm.design.pattern.adapter;

/**
 * @author chenkangqiang
 * @date 2017/8/31
 * @Description
 */

/**
 * 抽象成绩操作类：目标接口
 */
public interface ScoreOperation {
    /**
     * 成绩排序
     * @param array
     * @return
     */
    public int[] sort(int array[]);

    /**
     * 成绩查找
     * @param array
     * @param key
     * @return
     */
    public int search(int array[],int key);
}

