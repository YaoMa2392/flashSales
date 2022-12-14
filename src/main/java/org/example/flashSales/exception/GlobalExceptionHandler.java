package org.example.flashSales.exception;

import org.example.flashSales.result.CodeMsg;
import org.example.flashSales.result.ServerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description: 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ServerResponse<CodeMsg> exceptionHandler(HttpServletRequest request, Exception e) {
        // 打印log
        logger.error(e.getMessage());

        // 参数校验异常
        if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            List<ObjectError> errors = bindException.getAllErrors();
            String msg = errors.get(0).getDefaultMessage();
            return ServerResponse.error(CodeMsg.BIND_ERROR.fillMsg(msg));
        }
        // 全局异常
        else if (e instanceof GlobalException) {
            GlobalException globalException = (GlobalException) e;
            return ServerResponse.error(globalException.getCodeMsg());
        } else {
            return ServerResponse.error(CodeMsg.SERVER_ERROR);
        }
    }

}