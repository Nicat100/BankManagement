package com.company.bankmanager.exception;

import com.company.bankmanager.enums.ErrorCodeEnum;
import lombok.Getter;

@Getter
public class UserException extends RuntimeException {
    private final String message;
    private final int code;

    public UserException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.message = errorCodeEnum.getMessage();
        this.code = errorCodeEnum.getCode();
    }
}
