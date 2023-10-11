package com.company.bankmanager.enums;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum  {
    UNKNOWN_ERROR(1000, "Unknown error"),
    USER_NOT_FOUND(1001, "Cannot find user with given id "),
    NOT_ENOUGH_USER(1002, "User not found");
    private final int code;
    private final String message;

    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
