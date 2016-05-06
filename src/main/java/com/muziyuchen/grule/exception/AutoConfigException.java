package com.muziyuchen.grule.exception;

/**
 * Created by LI_ZHEN on 2016/5/6.
 */
public class AutoConfigException extends Exception {

    public AutoConfigException(String message) {
        super(message);
    }

    public AutoConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public AutoConfigException(Throwable cause) {
        super(cause);
    }
}
