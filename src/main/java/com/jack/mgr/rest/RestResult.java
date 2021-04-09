package com.jack.mgr.rest;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RestResult
 *
 * @author zhengzhe17
 * @date 2021/4/9
 */
@Data
@NoArgsConstructor
public class RestResult<T> {
    public static class RtnCode{
        public static final int OK = 0;
        public static final int UNKNOWN_ERROR = -1;
    }

    public int code = 0;
    public String msg = "success";
    public T data;

    public RestResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RestResult(T data) {
        this.data = data;
    }

    public static <T> RestResult<T> success() {
        return new RestResult();
    }

    public static <T> RestResult<T> success(T data) {
        return new RestResult(data);
    }

    public static <T> RestResult<T> error(int code, String msg) {
        return new RestResult(code, msg);
    }
}
