package com.muziyuchen.grule.condition;

import com.muziyuchen.grule.context.Context;
import com.muziyuchen.grule.exception.ConditionCheckException;
import com.muziyuchen.grule.manager.GroovyManager;

import java.io.File;
import java.lang.reflect.Method;

/**
 * Created by LI_ZHEN on 2016/5/5.
 */
public class GrovvyCondition extends AbstractCondition {

    private File _groovyScriptFile;

    private Boolean _result;

    public GrovvyCondition(File file) {
        this._groovyScriptFile = file;
    }

    public void check(Context context) throws ConditionCheckException {
        if (this._groovyScriptFile != null && this._groovyScriptFile.exists()) {
            try {
                Class conditionClass = GroovyManager.getInstance().getGroovyClassLoader().parseClass(this._groovyScriptFile);
                Method checkMethod = conditionClass.getMethod("check", Context.class);
                Object conditionInstance = conditionClass.newInstance();
                this._result = (Boolean)checkMethod.invoke(conditionInstance, context);
            } catch (Exception ignore) {
                throw new ConditionCheckException();
            }
        } else {
            throw new ConditionCheckException();
        }
    }

    public boolean getResult() {
        return this._result;
    }
}
