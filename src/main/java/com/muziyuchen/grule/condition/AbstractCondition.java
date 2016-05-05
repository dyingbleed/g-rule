package com.muziyuchen.grule.condition;

import com.muziyuchen.grule.Unit;
import com.muziyuchen.grule.action.Action;

/**
 * 抽象条件类
 * Created by LI_ZHEN on 2016/5/5.
 */
public abstract class AbstractCondition implements Condition {

    protected Unit _trueUnit = null;

    protected Unit _falseUnit = null;

    public final void registerTrueUnit(Unit unit) {
        this._trueUnit = unit;
    }

    public final void registerFalseUnit(Unit unit) {
        this._falseUnit = unit;
    }

    public final Unit next() {
        if (this.getResult()) {
            return this._trueUnit;
        } else {
            return this._falseUnit;
        }
    }
}
