package com.muziyuchen.grule.action;

import com.muziyuchen.grule.context.Context;
import com.muziyuchen.grule.exception.UnitRunException;
import com.muziyuchen.grule.manager.GroovyManager;

import java.io.File;
import java.lang.reflect.Method;

/**
 * Groovy 动作类
 * Created by LI_ZHEN on 2016/5/5.
 */
public class GroovyAction extends AbstractAction {

    private File _groovyScriptFile;

    /**
     * Groovy 动作类
     * @param file Groovy 脚本文件
     * */
    public GroovyAction(File file) {
        super();
        this._groovyScriptFile = file;
    }

    public void run(Context context) throws UnitRunException {
        if (this._groovyScriptFile != null && this._groovyScriptFile.exists()) {
            try {
                Class actionClass = GroovyManager.getInstance().getGroovyClassLoader().parseClass(this._groovyScriptFile);
                Method runMethod = actionClass.getMethod("run", Context.class);
                Object actionInstance = actionClass.newInstance();
                runMethod.invoke(actionInstance, context);
            } catch (Exception ignore) {
                throw new UnitRunException();
            }
        } else {
            throw new UnitRunException();
        }
    }
}
