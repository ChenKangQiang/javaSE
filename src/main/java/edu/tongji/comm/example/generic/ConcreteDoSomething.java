package edu.tongji.comm.example.generic;

/**
 * @author chenkangqiang
 * @date 2017/9/12
 */

/**
 * 实现泛型接口，类名后面要加泛型参数
 *
 * @param <T>
 */
public class ConcreteDoSomething<T> implements DoSomething<T> {
    @Override
    public T finish() {
        return null;
    }
}
