package com.liuyibo.me.exception;

/**
 * @Author liuyibo
 * @Date 2019-05-20
 * @Desc
 */
public class DaoException extends RuntimeException {

    private static final long serialVersionUID = -5160867870163756406L;

    public DaoException(String msg) {
        super(msg);
    }
}
