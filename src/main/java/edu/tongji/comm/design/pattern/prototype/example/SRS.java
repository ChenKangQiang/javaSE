package edu.tongji.comm.design.pattern.prototype.example;

/**
 * @author chenkangqiang
 * @date 2017/8/29
 * @Description
 */

/**
 * 软件需求规格说明书(Software Requirements Specification)类
 */
public class SRS implements OfficialDocument {

    @Override
    public OfficialDocument clone() {
        SRS document = null;
        try {
            document = (SRS) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void display() {
        System.out.println("《软件需求规格说明书》");
    }
}
