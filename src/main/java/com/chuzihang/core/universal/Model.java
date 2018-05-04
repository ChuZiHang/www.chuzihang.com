package com.chuzihang.core.universal;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName Model
 * @Description 所有model重写toString方法
 * @Author Q_先生
 * @Date 2018/4/27 15:14
 **/
public class Model {

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":" + JSON.toJSONString(this) + "\n";
    }
}
