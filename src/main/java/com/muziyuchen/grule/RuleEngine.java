package com.muziyuchen.grule;

import com.muziyuchen.grule.action.Action;
import com.muziyuchen.grule.condition.Condition;
import com.muziyuchen.grule.context.Context;

/**
 * Created by LI_ZHEN on 2016/5/5.
 */
public class RuleEngine {
    private static RuleEngine sharedInstance = new RuleEngine();

    public static RuleEngine getInstance() {
        return sharedInstance;
    }

    private Object _entry;

    private RuleEngine() {
    }

    private void runLoop(Object run, Context context) {
        if (run != null) {
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
        }
    }

    public void run(Context context) {
        runLoop(this._entry, context);
    }

    public RuleEngine setEntry(Action action) {
        this._entry = action;
        return this;
    }

    public RuleEngine setEntry(Condition condition) {
        this._entry = condition;
        return this;
    }

}
