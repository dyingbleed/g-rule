package com.muziyuchen.grule.manager;

import groovy.lang.GroovyClassLoader;

/**
 * Created by LI_ZHEN on 2016/5/5.
 */
public class GroovyManager {
    private static GroovyManager sharedInstance = new GroovyManager();

    public static GroovyManager getInstance() {
        return sharedInstance;
    }

    private GroovyClassLoader _classLoader;

    private GroovyManager() {
        this._classLoader = new GroovyClassLoader();
    }

    public GroovyClassLoader getGroovyClassLoader() {
        return this._classLoader;
    }

}
