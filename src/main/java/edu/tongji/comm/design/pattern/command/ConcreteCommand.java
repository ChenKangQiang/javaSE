package edu.tongji.comm.design.pattern.command;

/**
 * @Author chenkangqiang
 * @Data 2017/9/2
 * @Description
 */

import com.google.common.collect.Maps;
import lombok.Data;
import java.util.Map;

/**
 * 具体命令类
 */

@Data
public class ConcreteCommand implements Command {

    private Adder adder = new Adder();
    private int index = 0;
    /**
     * 存储操作数，可用于多次撤销
     */
    private Map<Integer, Integer> values = Maps.newHashMap();

    @Override
    public int execute(int value) {
        values.put(++index, value);
        return adder.add(value);
    }

    @Override
    public int undo() {
        int removeValue = values.remove(index--);
        return adder.add(-removeValue);
    }
}
