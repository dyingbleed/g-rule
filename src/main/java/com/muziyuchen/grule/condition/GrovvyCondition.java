package com.muziyuchen.grule.condition;

import com.muziyuchen.grule.context.Context;
import com.muziyuchen.grule.exception.UnitRunException;
import com.muziyuchen.grule.manager.GroovyManager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Groovy 条件类
 * Created by LI_ZHEN on 2016/5/5.
 */
public class GrovvyCondition extends AbstractCondition {

    private File _groovyScriptFile;

    private Boolean _result;

    /**
     * Groovy 条件类
     * @param file Groovy 脚本文件
     * */
    public GrovvyCondition(File file) {
        super();
        this._groovyScriptFile = file;
    }

    public void run(Context context) throws UnitRunException {
        if (this._groovyScriptFile != null && this._groovyScriptFile.exists()) {
            try {
                Class conditionClass = GroovyManager.getInstance().getGroovyClassLoader().parseClass(this._groovyScriptFile);
                Method checkMethod = conditionClass.getMethod("run", Context.class);
                Object conditionInstance = conditionClass.newInstance();
                this._result = (Boolean)checkMethod.invoke(conditionInstance, context);
            } catch (IOException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                throw new UnitRunException(e);
            }
        } else {
            throw new UnitRunException("Groovy file is null or not exist.");
        }
    }

    public boolean getResult() {
        return this._result;
    }
}
