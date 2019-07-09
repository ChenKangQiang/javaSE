package edu.tongji.comm.example.exception;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/8/2
 */
public class ExceptionDemo {

    public static void main(String[] args) {
        try {
            try {
                throw new NullPointerException();
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}
