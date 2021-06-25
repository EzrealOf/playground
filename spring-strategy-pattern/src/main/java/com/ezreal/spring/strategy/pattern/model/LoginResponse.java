package com.ezreal.spring.strategy.pattern.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2021/6/25.
 *
 * @author Ezreal
 * @since 2.0.0
 */

@Data
public class LoginResponse<T> implements Serializable {

    private static java.lang.String SUCCESSMSG = "处理成功";
    private static java.lang.String ERRORMSG = "操作失败";
    private static java.lang.String ERRORCODE = "500";
    private static java.lang.String SUCCESSCODE = "200";

    private Boolean status;
    private java.lang.String msg;
    private java.lang.String code;
    private T data;


    public static <T> LoginResponse<T> success(T data) {
        Boolean status = Boolean.TRUE;
        java.lang.String code = SUCCESSCODE;
        java.lang.String msg = SUCCESSMSG;
        if (data instanceof Boolean && Boolean.FALSE.equals(data)) {
            code = ERRORCODE;
            msg = ERRORMSG;
        }

        return result(data, status, code, msg);
    }
    private static <T> LoginResponse<T> result(T data, Boolean status, String code, String msg) {
        LoginResponse<T> result = new LoginResponse();
        result.setStatus(status);
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }
}
