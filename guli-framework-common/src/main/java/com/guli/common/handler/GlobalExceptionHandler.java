package com.guli.common.handler;

import com.guli.common.exception.GuliException;
import com.guli.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public R error(GuliException e) {
        log.error(e.getMessage());
        return R.error().message(e.getMessage()).code(e.getCode());
    }
}
