package com.muziyuchen.grule.action;

import com.muziyuchen.grule.condition.Condition;
import com.muziyuchen.grule.context.Context;

/**
 * Created by LI_ZHEN on 2016/5/5.
 */
public interface Action {

    public void run(Context context);

    public void registerCondition(Condition condition);

    public Condition next();

}
