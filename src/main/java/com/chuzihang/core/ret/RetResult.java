package com.chuzihang.core.ret;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @ClassName RetResult
 * @Description 返回对象实体
 * @Author Q_先生
 * @Date 2018/4/27 14:54
 **/
public class RetResult<T> implements Serializable {

    private static final long serialVersionUID = 3758864789222317092L;

    public int code;

    private String msg;

    private T data;

    public RetResult<T> setCode(RetCode retCode) {
        this.code = retCode.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public RetResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RetResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public RetResult<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
