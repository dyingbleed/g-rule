package com.muziyuchen.grule.action;

import com.muziyuchen.grule.context.Context;
import com.muziyuchen.grule.exception.UnitRunException;

import static org.junit.Assert.*;

/**
 * Created by LI_ZHEN on 2016/5/6.
 */
public class ActionTest extends AbstractAction {
    @Override
    public void run(Context context) throws UnitRunException {
        assertEquals(context.get("test"), "hello");
    }
}
