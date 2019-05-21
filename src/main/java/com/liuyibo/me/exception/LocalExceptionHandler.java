package com.liuyibo.me.exception;

import com.liuyibo.me.component.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author liuyibo
 * @Date 2019-05-20
 * @Desc
 */
@Slf4j
@ControllerAdvice
public class LocalExceptionHandler {

    @ExceptionHandler(BizException.class)
    @ResponseBody
    public Response bizException(BizException bizException) {
        log.info("[bizException] msg:{}", bizException.getMessage());
        return Response.failedResponse(bizException.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response exception(Exception exception) {
        log.error("[exception], ", exception);
        return Response.failedResponse(exception.getMessage());
    }

}
