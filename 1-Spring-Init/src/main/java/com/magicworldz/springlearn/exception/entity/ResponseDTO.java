package com.magicworldz.springlearn.exception.entity;

import lombok.Data;

@Data
public class ResponseDTO <T> {

    protected int errCode;
    protected String message;
    protected T data;

    public ResponseDTO(int errCode, String message, T data) {
        this.errCode = errCode;
        this.message = message;
        this.data = data;
    }

    public ResponseDTO(ErrorCode errCode, T data) {
        this(errCode.getErrCode(), errCode.getMessage(), data);
    }

    public static <T> ResponseDTO<T> success() {
        return new ResponseDTO<>(ErrorCode.SUCCESS, null);
    }

    public static <T> ResponseDTO<T> success(T data) {
        return new ResponseDTO<>(ErrorCode.SUCCESS, data);
    }

    public static <T> ResponseDTO<T> fail(String message) {
        return new ResponseDTO<>(ErrorCode.SYSTEM_ERROR.getErrCode(), message, null);
    }

    public static <T> ResponseDTO<T> fail() {
        return new ResponseDTO<>(ErrorCode.SYSTEM_ERROR, null);
    }

    public static <T> ResponseDTO<T> fail(int errCode, String message) {
        if (errCode == ErrorCode.SUCCESS.getErrCode()) {
            throw new IllegalArgumentException("Request to constuct a failed ResponseDTO, but given a success error code.");
        }
        return new ResponseDTO<>(errCode, message, null);
    }
}