package edu.tongji.comm.example.innerclass;

/**
 * @author chenkangqiang
 * @date 2017/9/11
 */


/**
 * 内部类
 */
public class Outer {

    private int outerId;
    private String outerName;
    private Inner inner = new Inner();

    public class Inner {
        private int innerId;
        private String innerName;
    }

}
