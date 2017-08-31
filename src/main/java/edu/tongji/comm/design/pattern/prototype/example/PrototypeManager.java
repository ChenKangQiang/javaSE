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
        documents.put("FAR", new FAR());
        documents.put("SRS", new SRS());
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

    /**
     * 添加公文模板
     * @param key
     * @param document
     */
    public void addOfficialDocument(String key, OfficialDocument document) {
        documents.put(key, document);
    }

    /**
     * 浅克隆获取公文模板
     * @param key
     * @return
     */
    public OfficialDocument getOfficialDocument(String key) {
        return  documents.get(key).clone();
    }


    public Map<String, OfficialDocument> getDocuments() {
        return documents;
    }


}
