package com.muziyuchen.grule;

import com.muziyuchen.grule.action.Action;
import com.muziyuchen.grule.condition.Condition;
import com.muziyuchen.grule.context.Context;
import com.muziyuchen.grule.exception.ActionRunException;
import com.muziyuchen.grule.exception.ConditionCheckException;

/**
 * Created by LI_ZHEN on 2016/5/5.
 */
public class RuleEngine {
    private static RuleEngine sharedInstance = new RuleEngine();

    public static RuleEngine getInstance() {
        return sharedInstance;
    }

    private Unit _entry;

    private RuleEngine() {
    }

    private void runLoop(Object run, Context context) {
        if (run != null) {
            try {
                if (run instanceof Action) {
                    Action action = (Action) run;
                    action.run(context);
                    runLoop(action.next(), context);
                } else if (run instanceof Condition) {
                    Condition condition = (Condition) run;
                    condition.check(context);
                    runLoop(condition.next(), context);
                } else {
                    // do nothing
                }
            } catch (ActionRunException | ConditionCheckException e) {
                e.printStackTrace();
            }
        }
    }

    public void run(Context context) {
        runLoop(this._entry, context);
    }

    public RuleEngine setEntry(Unit action) {
        this._entry = action;
        return this;
    }

}
