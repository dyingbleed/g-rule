package com.muziyuchen.grule;

import com.muziyuchen.grule.context.Context;
import com.muziyuchen.grule.exception.AutoConfigException;
import com.muziyuchen.grule.exception.UnitRunException;

/**
 * 规则引擎
 * Created by LI_ZHEN on 2016/5/5.
 */
public class RuleEngine {
    private static RuleEngine sharedInstance = new RuleEngine();

    /**
     * 获取规则引擎实例
     * @return 规则引擎共享实例
     * */
    public static RuleEngine getInstance() {
        return sharedInstance;
    }

    private Unit entry;

    private RuleEngine() {
    }

    /**
     * 执行循环遍历单元
     * @param unit 单元
     * @param context 执行上下文
     * */
    private void runLoop(Unit unit, Context context) {
        if (unit != null) {
            try {
                unit.run(context);
                runLoop(unit.next(), context);
            } catch (UnitRunException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 运行规则引擎
     * @param context 上下文
     * */
    public void run(Context context) {
        if (context == null) throw new IllegalArgumentException("Context should not be null.");
        runLoop(this.entry, context);
    }

    /**
     * 设置入口单元
     * @param unit 单元
     * @return 规则引擎
     * */
    public RuleEngine setEntry(Unit unit) {
        this.entry = unit;
        return this;
    }

    /**
     * 获取入口单元
     * @return 入口单元
     * */
    public Unit getEntry() {
        return this.entry;
    }

    /**
     * 使用 JSON 配置文件自动装配规则引擎
     * @param json JSON 配置文件
     * */
    public RuleEngine config(String json) throws AutoConfigException {
        if (json != null && json.trim().length() != 0) {
            try {
                setEntry(JSONConfigHelper.parse(json));
            } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                throw new AutoConfigException(e);
            }
        }
        return this;
    }

}
