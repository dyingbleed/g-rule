package com.muziyuchen.grule.condition;

import com.muziyuchen.grule.action.Action;
import com.muziyuchen.grule.context.Context;

/**
 * Created by LI_ZHEN on 2016/5/5.
 */
public abstract class AbstractCondition implements Condition {

    protected Action _trueAction = null;

    protected Action _falseAction = null;

    public final void registerTrueAction(Action action) {
        this._trueAction = action;
    }

    public final void registerFalseAction(Action action) {
        this._falseAction = action;
    }

    public final Action next() {
        if (this.getResult()) {
            return this._trueAction;
        } else {
            return this._falseAction;
        }
    }
}
