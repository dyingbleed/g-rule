package com.muziyuchen.grule.condition;

import com.muziyuchen.grule.context.Context;
import com.muziyuchen.grule.exception.UnitRunException;
import com.muziyuchen.grule.manager.GroovyManager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Groovy 条件类
 * Created by LI_ZHEN on 2016/5/5.
 */
public class GrovvyCondition extends AbstractCondition {

    private Class groovyClass = null;

    private String path;
    private String script;

    private Boolean result = false;

    /**
     * Groovy 条件类
     * */
    public GrovvyCondition() { super(); }

    /**
     * Groovy 条件类
     * @param file Groovy 脚本文件
     * @throws IOException
     * */
    public GrovvyCondition(File file) throws IOException {
        super();
        if (file != null && file.exists()) this.groovyClass = GroovyManager.getInstance().getGroovyClassLoader().parseClass(file);
    }

    /**
     * Groovy 条件类
     * @param script Groovy 脚本
     * */
    public GrovvyCondition(String script) {
        super();
        if (script != null && script.trim().length() != 0) this.groovyClass = GroovyManager.getInstance().getGroovyClassLoader().parseClass(script);
    }

    public void run(Context context) throws UnitRunException {
        try {
            if (this.groovyClass == null) {
                /*
                 * 如果 Groovy 类为空
                 * 根据 path 和 script 字段获取 Groovy 类
                 */
                if (this.path != null && this.path.trim().length() != 0) {
                    File file = new File(this.path);
                    if (file.exists()) this.groovyClass = GroovyManager.getInstance().getGroovyClassLoader().parseClass(file);
                } else if (this.script != null && this.script.trim().length() != 0) {
                    this.groovyClass = GroovyManager.getInstance().getGroovyClassLoader().parseClass(script);
                }
            }

            this.result = (Boolean) GroovyManager.getInstance().invokeMethod(this.groovyClass, "run", context);
        } catch (IOException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new UnitRunException(e);
        }
    }

    public boolean getResult() {
        return this.result;
    }
}
