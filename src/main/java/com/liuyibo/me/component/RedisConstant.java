package com.liuyibo.me.component;

/**
 * @Author liuyibo
 * @Date 2019-05-21
 * @Desc
 */
public class RedisConstant {

    private static final String KEY_PREFIX = "um:qun:";

    private static final String LAST_WARN_TIME_KEY = "lastWarnTimeKey";

    public static String genKey4LastWarnTime() {
        return KEY_PREFIX + LAST_WARN_TIME_KEY;
    }

}
