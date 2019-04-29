package com.sharetocare.prototype.controller.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T>{

    private int status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer errorCode;

    private String message;

    private T body;

    private static String SUCCESS = "Operation Successful";


    public Response()
    {
        this.status = ResponseStatus.SUCCESS.ordinal();
        this.message = SUCCESS;
        this.body = null;
        this.errorCode = null;
    }


    public Response(int status, String message , T body)
    {
        this.status = status;
        this.message = message;
        this.body = body;
        this.errorCode = null;
    }

    public static <T> Response<T> success(T body)
    {
        Response base = new Response(ResponseStatus.SUCCESS.ordinal(),SUCCESS,body);
        return base;
    }


    public static <T> Response<T> success()
    {
        Response base = new Response(ResponseStatus.SUCCESS.ordinal(),SUCCESS,null);
        return base;
    }


    public static <T> Response error(String message, T body) {
        Response base = new Response(ResponseStatus.ERROR.ordinal(), message, body);
        return base;
    }

    public static Response error(int errorCode, String message) {
        Response base = new Response(ResponseStatus.ERROR.ordinal(), message, null);
        base.setErrorCode(errorCode);
        return base;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}