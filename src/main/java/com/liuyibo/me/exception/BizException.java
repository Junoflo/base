package com.liuyibo.me.exception;

/**
 * @Author liuyibo
 * @Date 2019-05-20
 * @Desc
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -1722600463643282465L;

    public BizException(String msg) {
        super(msg);
    }
}
