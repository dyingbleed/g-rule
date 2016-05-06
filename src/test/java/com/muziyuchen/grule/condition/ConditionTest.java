package com.muziyuchen.grule.condition;

import com.muziyuchen.grule.context.Context;
import com.muziyuchen.grule.exception.UnitRunException;

/**
 * Created by LI_ZHEN on 2016/5/6.
 */
public class ConditionTest extends AbstractCondition {
    @Override
    public boolean getResult() {
        return true;
    }

    @Override
    public void run(Context context) throws UnitRunException {
        context.put("test", "hello");
    }
}
