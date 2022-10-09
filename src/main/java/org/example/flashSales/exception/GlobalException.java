package org.example.flashSales.exception;

import org.example.flashSales.result.CodeMsg;

/**
 * @description: 定义封装CodeMsg的全局异常，用于Service中错误向外直接抛出，并由全局异常处理器捕获处理
 */
public class GlobalException extends RuntimeException {

    private CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg) {
        this.codeMsg = codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
}