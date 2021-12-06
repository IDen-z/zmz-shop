package com.zmz.common.exception;

import com.zmz.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 集中处理所有的异常
 * @Author: Zhu Mengze
 * @Date: 2021/11/12 13:48
 */

@ControllerAdvice
@Slf4j
public class ZshopGlobalException {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public R handlerExcption(Exception e) {
        log.error("操作失败", e);
        return R.error(CodeEnum.UNKNOW_EXCEPTION.getCode(), CodeEnum.UNKNOW_EXCEPTION.getMsg());
    }


}
