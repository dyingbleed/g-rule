package com.muziyuchen.grule.condition;

import com.muziyuchen.grule.Unit;
import com.muziyuchen.grule.action.Action;
import com.muziyuchen.grule.context.Context;
import com.muziyuchen.grule.exception.ConditionCheckException;

/**
 * Created by LI_ZHEN on 2016/5/5.
 */
public interface Condition extends Unit {

    public void check(Context context) throws ConditionCheckException;

    public boolean getResult();

    public void registerTrueAction(Action action);

    public void registerFalseAction(Action action);

}
