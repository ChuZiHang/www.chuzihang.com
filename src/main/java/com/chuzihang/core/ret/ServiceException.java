package com.chuzihang.core.ret;

import java.io.Serializable;

/**
 * @ClassName ServiceException
 * @Description 业务类异常
 * @Author Q_先生
 * @Date 2018/4/27 14:56
 **/
public class ServiceException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1213855733833039552L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
