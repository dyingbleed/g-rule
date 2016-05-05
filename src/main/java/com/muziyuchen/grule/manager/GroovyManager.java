package com.muziyuchen.grule.manager;

import groovy.lang.GroovyClassLoader;

/**
 * Groovy 管理者
 * Created by LI_ZHEN on 2016/5/5.
 */
public class GroovyManager {
    private static GroovyManager sharedInstance = new GroovyManager();

    /**
     * 获取 Groovy 管理者实例
     * @return 返回共享实例
     * */
    public static GroovyManager getInstance() {
        return sharedInstance;
    }

    private GroovyClassLoader _classLoader;

    private GroovyManager() {
        this._classLoader = new GroovyClassLoader();
    }

    /**
     * 获取 Groovy 类加载器
     * @return Groovy 类加载器实例
     * */
    public GroovyClassLoader getGroovyClassLoader() {
        return this._classLoader;
    }

}
