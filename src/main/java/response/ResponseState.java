/*
 * Date: 2021/6/18
 * Author: <https://www.github.com/shaozk>
 */

package response;

import lombok.Data;

/**
 * @author shaozk
 */
public enum ResponseState {
    SUCCESS(true, 200, "操作成功"),
    FAILED(false, 400, "操作失败"),
    JOIN_IN_SUCCESS(true, 202, "注册成功"),
    GET_RESOURCE_FAILED(false, 401, "获取资源失败"),
    ACCOUNT_NOT_LOGIN(false, 402, "账号未登录"),
    ACCOUNT_FORBID(false, 402, "账号被禁止"),
    PERMISSION_DENIED(false, 403, "无权访问"),
    LOGIN_SUCCESS(true, 201, "登录成功"),
    LOGIN_FAILED(false, 499, "登录失败"),
    ERROR_404(false, 404, "页面丢失"),
    ERROR_403(false, 403, "权限不足"),
    ERROR_505(false, 505, "请求错误，请检查所提交数据"),
    ERROR_504(false, 504, "系统繁忙，请稍后再试");

    ResponseState(boolean success, int code, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }

    private int code;
    private String message;
    private boolean success;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
