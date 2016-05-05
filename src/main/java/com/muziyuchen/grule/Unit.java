package com.muziyuchen.grule;

import com.muziyuchen.grule.context.Context;
import com.muziyuchen.grule.exception.UnitRunException;

/**
 * 单元接口
 * Created by LI_ZHEN on 2016/5/5.
 */
public interface Unit {

    /**
     * 返回下一个单元
     * @return 返回下一个单元，未执行或不存在返回 null
     * */
    public Unit next();

    /**
     * 执行单元
     * @param context 执行上下文
     * @throws UnitRunException 单元执行异常
     * */
    public void run(Context context) throws UnitRunException;

}
