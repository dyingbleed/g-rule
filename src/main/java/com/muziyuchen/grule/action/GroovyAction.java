package com.muziyuchen.grule.action;

import com.muziyuchen.grule.context.Context;
import com.muziyuchen.grule.exception.ActionRunException;
import com.muziyuchen.grule.manager.GroovyManager;

import java.io.File;
import java.lang.reflect.Method;

/**
 * Created by LI_ZHEN on 2016/5/5.
 */
public class GroovyAction extends AbstractAction {

    private File _groovyScriptFile;

    public GroovyAction(File file) {
        this._groovyScriptFile = file;
    }

    public void run(Context context) throws ActionRunException {
        if (this._groovyScriptFile != null && this._groovyScriptFile.exists()) {
            try {
                Class actionClass = GroovyManager.getInstance().getGroovyClassLoader().parseClass(this._groovyScriptFile);
                Method runMethod = actionClass.getMethod("run", Context.class);
                Object actionInstance = actionClass.newInstance();
                runMethod.invoke(actionInstance, context);
            } catch (Exception ignore) {
                throw new ActionRunException();
            }
        } else {
            throw new ActionRunException();
        }
    }
}
