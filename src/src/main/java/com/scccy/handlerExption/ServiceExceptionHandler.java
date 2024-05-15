package com.scccy.handlerExption;

import com.scccy.common.ResultData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice("com.scccy.service")
public class ServiceExceptionHandler {
    // 处理自定义异常，通常用于业务逻辑错误，例如无效的用户操作等
    @ExceptionHandler(GlobalExceptionHandler.CustomException.class)
    public ResponseEntity<ResultData> handleCustomException(GlobalExceptionHandler.CustomException ex, WebRequest request) {
        // 返回客户端一个BAD_REQUEST(400)响应，以及异常信息
        return new ResponseEntity<>(ResultData.fail().setData(400).setMsg(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
