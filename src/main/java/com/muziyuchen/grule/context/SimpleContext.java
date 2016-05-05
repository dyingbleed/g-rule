package com.muziyuchen.grule.context;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单的上下文实现
 * Created by LI_ZHEN on 2016/5/5.
 */
public class SimpleContext implements Context {

    private Map<String, Object> _map;

    public SimpleContext() {
        this._map = new HashMap<String, Object>();
    }

    public void put(String key, Object value) {
        this._map.put(key, value);
    }

    public Object get(String key) {
        return this._map.get(key);
    }
}
