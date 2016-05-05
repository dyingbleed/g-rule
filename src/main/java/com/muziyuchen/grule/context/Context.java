package com.muziyuchen.grule.context;

/**
 * Created by LI_ZHEN on 2016/5/5.
 */
public interface Context {

    public void set(String key, Object value);

    public Object get(String key);

}
