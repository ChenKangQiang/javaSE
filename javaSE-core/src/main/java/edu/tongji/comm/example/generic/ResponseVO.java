package edu.tongji.comm.example.generic;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/5/30
 */

public abstract class ResponseVO<T> {

    protected Data<T> aaa;

    protected int code;
    protected String msg;
    protected T date;

    public ResponseVO() {

    }

    public ResponseVO(int code, String msg, T date, Data<T> aaa) {
        this.code = code;
        this.msg = msg;
        this.date = date;
        this.aaa = aaa;
    }

    public T getDate() {
        return date;
    }

    public abstract T doSomething();
}
