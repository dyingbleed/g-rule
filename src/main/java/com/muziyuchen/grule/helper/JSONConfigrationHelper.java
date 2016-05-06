package com.muziyuchen.grule.helper;

import com.alibaba.fastjson.JSONObject;
import com.muziyuchen.grule.Constants;
import com.muziyuchen.grule.Unit;
import com.muziyuchen.grule.action.Action;
import com.muziyuchen.grule.condition.Condition;

/**
 * Created by LI_ZHEN on 2016/5/6.
 */
public class JSONConfigrationHelper {

    private static Unit parseLoop(JSONObject jo) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Unit unit = null;
        if (jo != null) {
            String type = jo.getString(Constants.JSON_FIELDNAME_TYPE);
            Class unitClass = Class.forName(jo.getString(Constants.JSON_FIELDNAME_CLASS));

            if ("action".equals(type)) {
                Action action = (Action) unitClass.newInstance();
                action.registerUnit(parseLoop(jo.getJSONObject(Constants.JSON_FIELDNAME_ACTION_UNIT)));
                unit = action;
            } else if ("condition".equals(type)) {
                Condition condition = (Condition) unitClass.newInstance();
                condition.registerTrueUnit(parseLoop(jo.getJSONObject(Constants.JSON_FIELDNAME_CONDITION_TRUEUNIT)));
                condition.registerFalseUnit(parseLoop(jo.getJSONObject(Constants.JSON_FIELDNAME_CONDITION_FALSEUNIT)));
                unit = condition;
            } else {
                //TODO 无法识别的类型
            }
        }
        return unit;
    }

    /**
     * 解析 JSON 配置并返回入口单元
     * @param json JSON 配置
     * @return 入口单元
     * */
    public static Unit parse(String json) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Unit unit = null;

        if (json != null && json.trim().length() != 0) {
            unit = parseLoop(JSONObject.parseObject(json));
        }

        return unit;
    }

}
