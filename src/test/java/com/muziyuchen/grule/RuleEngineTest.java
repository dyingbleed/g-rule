package com.muziyuchen.grule;

import static org.mockito.Mockito.*;

import com.muziyuchen.grule.action.AbstractAction;
import com.muziyuchen.grule.action.Action;
import com.muziyuchen.grule.action.ActionTest;
import com.muziyuchen.grule.action.GroovyAction;
import com.muziyuchen.grule.condition.AbstractCondition;
import com.muziyuchen.grule.condition.Condition;
import com.muziyuchen.grule.condition.GrovvyCondition;
import com.muziyuchen.grule.condition.ConditionTest;
import com.muziyuchen.grule.context.SimpleContext;
import com.muziyuchen.grule.exception.AutoConfigException;
import org.junit.Test;

import java.io.IOException;

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
    public void testRunGroovy() throws IOException {
        String conditionScript = "import com.muziyuchen.grule.context.Context\n" +
                "class TestCondition {\n" +
                "    boolean run(Context contex) {\n" +
                "\t\tcontex.put(\"test\", \"hello\")\n" +
                "\t\treturn true\n" +
                "\t}\n" +
                "}";
        String actionScript = "import com.muziyuchen.grule.context.Context\n" +
                "import static org.junit.Assert.*;\n" +
                "class TestAction {\n" +
                "    void run(Context context) {\n" +
                "\t\tassertEquals(context.get(\"test\"), \"hello\")\n" +
                "\t}\n" +
                "}";
        Condition condition = new GrovvyCondition(conditionScript);
        GroovyAction action = new GroovyAction(actionScript);

        condition.registerTrueUnit(action);

        RuleEngine.getInstance().setEntry(condition).run(new SimpleContext());
    }

    @Test
    public void testJSONConfigRun() throws AutoConfigException {
        String json = "{\"type\":\"condition\",\"class\":\"" + ConditionTest.class.getName() + "\",\"true_unit\":{\"type\":\"action\",\"class\":\"" + ActionTest.class.getName() + "\"}}";
        RuleEngine.getInstance().config(json).run(new SimpleContext());
    }

}
