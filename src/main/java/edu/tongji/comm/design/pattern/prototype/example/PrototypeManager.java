package edu.tongji.comm.design.pattern.prototype.example;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author chenkangqiang
 * @date 2017/8/29
 * @Description
 */
public class PrototypeManager {

    private volatile static PrototypeManager prototypeManager = null;
    private Map<String, OfficialDocument> documents = Maps.newHashMap();

    private PrototypeManager() {

    }

    public static PrototypeManager getInstance() {
        if (prototypeManager == null) {
            synchronized (PrototypeManager.class) {
                if (prototypeManager == null) {
                    prototypeManager = new PrototypeManager();
                }
            }
        }
        return prototypeManager;
    }


}
