package com.lawrence.handle;

import com.lawrence.domain.Result;
import com.lawrence.exception.GirlException;
import com.lawrence.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liush
 * 2018/8/22   2:26
 */
@ControllerAdvice
public class ExceptionHandle {

    Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof GirlException){
            GirlException exception = (GirlException) e;
            return ResultUtil.error(exception.getCode(),exception.getMessage());
        }else
            logger.info("exception={}",e.getMessage());
            return ResultUtil.error(-1,e.getMessage());
    }
}
