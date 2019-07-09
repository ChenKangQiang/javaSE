package edu.tongji.comm.example.innerclass;

/**
 * @author chenkangqiang
 * @date 2017/9/11
 */
public class OuterWithStaticInner {

    private int outerId;
    private String outerName;

    public static class Inner {
        private int innerId;
        private String innerName;
    }

    public static enum Code {

        TYPE_A(1),
        TYPE_B(2);


        private int type;

        private Code(int type) {
            this.type = type;
        }

    }

}
