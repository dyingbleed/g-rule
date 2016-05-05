package com.muziyuchen.grule.action;

import com.muziyuchen.grule.Unit;
import com.muziyuchen.grule.condition.Condition;
import com.muziyuchen.grule.context.Context;
import com.muziyuchen.grule.exception.ActionRunException;

/**
 * Created by LI_ZHEN on 2016/5/5.
 */
public interface Action extends Unit {

    public void run(Context context) throws ActionRunException;

    public void registerCondition(Condition condition);

}
