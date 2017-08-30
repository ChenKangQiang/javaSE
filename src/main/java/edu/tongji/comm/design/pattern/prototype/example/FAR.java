package edu.tongji.comm.design.pattern.prototype.example;

/**
 * @author chenkangqiang
 * @date 2017/8/29
 * @Description
 */

/**
 * 可行性分析报告(Feasibility Analysis Report)类
 */
public class FAR implements OfficialDocument {

    @Override
    public OfficialDocument clone() {
        FAR document = null;
        try {
            document = (FAR) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return document;
    }

    @Override
    public void display() {
        System.out.println("《可行性分析报告》");
    }
}
