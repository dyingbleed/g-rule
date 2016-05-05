package com.muziyuchen.grule.action;

import com.muziyuchen.grule.Unit;
import com.muziyuchen.grule.condition.Condition;
import com.muziyuchen.grule.context.Context;

/**
 * 抽象动作类
 * Created by LI_ZHEN on 2016/5/5.
 */
public abstract class AbstractAction implements Action {

    protected Unit _unit;

    public final void registerUnit(Unit unit) {
        this._unit = unit;
    }

    public final Unit next() {
        return _unit;
    }
}
