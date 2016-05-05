package com.muziyuchen.grule.condition;

import com.muziyuchen.grule.action.Action;
import com.muziyuchen.grule.context.Context;

/**
 * Created by LI_ZHEN on 2016/5/5.
 */
public interface Condition {

    public void check(Context context);

    public boolean getResult();

    public void registerTrueAction(Action action);

    public void registerFalseAction(Action action);

    public Action next();

}
