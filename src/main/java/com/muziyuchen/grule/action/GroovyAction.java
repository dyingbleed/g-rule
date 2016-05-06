package com.muziyuchen.grule.action;

import com.muziyuchen.grule.context.Context;
import com.muziyuchen.grule.exception.UnitRunException;
import com.muziyuchen.grule.groovy.GroovyManager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Groovy 动作类
 * Created by LI_ZHEN on 2016/5/5.
 */
public class GroovyAction extends AbstractAction {

    private Class groovyClass;

    /**
     * Groovy 动作类
     * @param file Groovy 脚本文件
     * @throws IOException
     * */
    public GroovyAction(File file) throws IOException {
        super();
        if (file != null && file.exists()) this.groovyClass = GroovyManager.getInstance().getGroovyClassLoader().parseClass(file);
    }

    /**
     * Groovy 动作类
     * @param script Groovy 脚本
     * */
    public GroovyAction(String script) {
        super();
        if (script != null && script.trim().length() != 0) this.groovyClass = GroovyManager.getInstance().getGroovyClassLoader().parseClass(script);
    }

    public void run(Context context) throws UnitRunException {
        try {
            GroovyManager.getInstance().invokeMethod(this.groovyClass, "run", context);
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new UnitRunException(e);
        }
    }
}
