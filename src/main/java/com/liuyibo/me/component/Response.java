package com.liuyibo.me.component;

import lombok.Data;

/**
 * @Author liuyibo
 * @Date 2019-05-20
 * @Desc
 */
@Data
public class Response {

    private int code;
    private String msg;
    private Object data;

    private static final int CODE_SUCCESS = 200;
    private static final String MSG_SUCCESS = "success";
    private static final int CODE_FAILED = 400;
    private static final int CODE_ERROR = 500;

    private Response(int code) {
        this.code = code;
    }

    private Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Response(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Response successResponse(Object data) {
        return new Response(CODE_SUCCESS, MSG_SUCCESS, data);
    }

    public static Response failedResponse(String msg) {
        return new Response(CODE_FAILED, msg);
    }

}
