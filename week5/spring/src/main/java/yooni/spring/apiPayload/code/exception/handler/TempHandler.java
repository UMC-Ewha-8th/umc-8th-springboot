package yooni.spring.apiPayload.code.exception.handler;

import yooni.spring.apiPayload.code.BaseErrorCode;
import yooni.spring.apiPayload.code.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}