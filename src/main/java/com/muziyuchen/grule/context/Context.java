package com.muziyuchen.grule.context;

/**
 * 上下文接口
 * Created by LI_ZHEN on 2016/5/5.
 */
public interface Context {

    /**
     * 向上下文中添加数据
     * @param key 键
     * @param value 值
     * */
    public void put(String key, Object value);

    /**
     * 从上下文中获取数据
     * @param key 键
     * @return 值
     * */
    public Object get(String key);

}
