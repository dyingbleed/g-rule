package com.muziyuchen.grule;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import com.muziyuchen.grule.action.AbstractAction;
import com.muziyuchen.grule.action.Action;
import com.muziyuchen.grule.action.GroovyAction;
import com.muziyuchen.grule.condition.AbstractCondition;
import com.muziyuchen.grule.condition.Condition;
import com.muziyuchen.grule.condition.GrovvyCondition;
import com.muziyuchen.grule.context.SimpleContext;
import org.junit.Test;

import java.io.File;

/**
 * 规则引擎测试类
 * Created by LI_ZHEN on 2016/5/6.
 */
public class RuleEngineTest {

    @Test
    public void testRun() {
        Condition condition = mock(AbstractCondition.class);
        Action action = mock(AbstractAction.class);

        condition.registerTrueUnit(action);
        when(condition.getResult()).thenReturn(true);

        RuleEngine.getInstance().setEntry(condition).run(new SimpleContext());
    }

    @Test
    public void testRunGroovy() {
        Condition condition = new GrovvyCondition(new File("C:\\Users\\LI_ZHEN\\Desktop\\TestCondition.groovy"));
        GroovyAction action = new GroovyAction(new File("C:\\Users\\LI_ZHEN\\Desktop\\TestAction.groovy"));

        condition.registerTrueUnit(action);

        RuleEngine.getInstance().setEntry(condition).run(new SimpleContext());
    }

}
