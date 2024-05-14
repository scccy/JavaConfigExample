package com.scccy.spring.handler;

import com.scccy.common.ResultData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 处理自定义异常
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ResultData> handleCustomException(CustomException ex, WebRequest request) {
        return new ResponseEntity<>(ResultData.fail().setMsg(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    // 处理方法参数无效异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResultData> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(ResultData.fail().setMsg("Validation failed").setData(errors), HttpStatus.BAD_REQUEST);
    }

    // 处理所有其他异常
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResultData> handleGlobalException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ResultData.fail().setMsg("An unexpected error occurred"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 自定义异常类
    public static class CustomException extends RuntimeException {
        public CustomException(String message) {
            super(message);
        }
    }
}
