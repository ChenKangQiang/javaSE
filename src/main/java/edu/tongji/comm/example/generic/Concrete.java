package edu.tongji.comm.example.generic;

/**
 * @author chenkangqiang
 * @date 2017/9/12
 */
public class Concrete<String> implements DoSomething<String> {
    @Override
    public String finish() {
        return null;
    }
}
