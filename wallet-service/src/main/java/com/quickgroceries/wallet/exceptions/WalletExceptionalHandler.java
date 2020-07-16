package com.quickgroceries.wallet.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WalletExceptionalHandler {

    @ExceptionHandler(value = { Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse unknownException(Exception exception){
        return new ErrorResponse(exception.getLocalizedMessage(),501);
    }
    
    @ExceptionHandler(value = { WalletException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse generalException(WalletException walletException){
        return new ErrorResponse(walletException.getLocalizedMessage(),walletException.getErrorCode());
    }
}
