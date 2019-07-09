package edu.tongji.comm.example.innerclass;

/**
 * @author chenkangqiang
 * @date 2017/9/15
 *
 * 1. 接口中所有成员属性，均是默认 public static final 的
 * 2. 接口中的内部类默认是 public static 的
 * 3. default方法，强制为public
 * 4. static方法，强制为public
 */
public interface InterfaceA {
    public static final Integer a = 100;

    public abstract void func1();

    public static void help() {

    }

    default public void func2() {

    }

    Kind KIND1 = Kind.ERROR;
    Kind KIND2 = Kind.TRUE;

    public static enum Kind {
        ERROR,
        TRUE
    }

    public static final class InnerA {

    }

    public static class InnerB {

    }

    class InnerC {

    }



}
