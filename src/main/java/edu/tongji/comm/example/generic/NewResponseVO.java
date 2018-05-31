package edu.tongji.comm.example.generic;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/5/30
 */
public class NewResponseVO<K, T> extends ResponseVO<T> {
    K newData;

    @Override
    public T doSomething() {
        return null;
    }

    public NewResponseVO(K newData) {
        this.newData = newData;
    }

    public NewResponseVO(int code, String msg, T date, Data<T> aaa, K newData) {
        super(code, msg, date, aaa);
        this.newData = newData;
    }
}



class NewResponseVO2 extends ResponseVO {

    @Override
    public Object doSomething() {
        return null;
    }

    public NewResponseVO2(int code, String msg, Object date, Data aaa) {
        super(code, msg, date, aaa);
    }
}


class NewResponseVO3<T, K extends T> extends ResponseVO<T> {
    @Override
    public T doSomething() {
        return null;
    }
}


class NewResponseVO4 extends ResponseVO<Integer> {
    @Override
    public Integer doSomething() {
        return null;
    }
}


class NewResponseVO5<T> extends ResponseVO<Integer> {
    T otherData;

    @Override
    public Integer doSomething() {
        return null;
    }
}

