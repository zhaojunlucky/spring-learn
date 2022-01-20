package com.magicworldz.springlearn.exception;

import lombok.Getter;

public enum ErrorCode {
    SUCCESS(0, ""),
    USER_ERROR(203, "User Error"),
    SYSTEM_ERROR(204, "System Error");

    @Getter
    private int errCode;
    @Getter
    private String message;

    ErrorCode(int errorCode, String message) {
        this.errCode = errorCode;
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("error code:%d, message %s.", this.errCode, this.message);
    }

}