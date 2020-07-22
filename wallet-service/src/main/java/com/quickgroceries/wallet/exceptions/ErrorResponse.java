package com.quickgroceries.wallet.exceptions;

public class ErrorResponse extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String exceptionMsg;
    private int httpCode;

    public ErrorResponse(){

    }

    public ErrorResponse(String exceptionMsg, int httpCode) {
        this.exceptionMsg = exceptionMsg;
        this.httpCode = httpCode;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }
}
