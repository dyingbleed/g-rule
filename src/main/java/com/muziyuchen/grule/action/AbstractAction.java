package com.muziyuchen.grule.action;

import com.muziyuchen.grule.condition.Condition;
import com.muziyuchen.grule.context.Context;

/**
 * Created by LI_ZHEN on 2016/5/5.
 */
public abstract class AbstractAction implements Action {

    protected Condition _condition;

    public final void registerCondition(Condition condition) {
        this._condition = condition;
    }

    public final Condition next() {
        return _condition;
    }
}
