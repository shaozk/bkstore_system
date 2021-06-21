/*
 * Date: 2021/6/11
 * Author: <https://www.github.com/shaozk>
 */

package response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author shaozk
 */
@Data
@AllArgsConstructor
public class ResponseResult {
    private boolean success;
    private int code;
    private String message;
    private Object data;

    public ResponseResult(ResponseState responseState) {
        this.success = responseState.isSuccess();
        this.code = responseState.getCode();
        this.message = responseState.getMessage();
    }
    public static ResponseResult GET(ResponseState state) {
        return new ResponseResult(state);
    }

    public static ResponseResult SUCCESS() {
        return new ResponseResult(ResponseState.SUCCESS);
    }

    public static ResponseResult SUCCESS(String message) {
        ResponseResult responseResult = new ResponseResult(ResponseState.SUCCESS);
        responseResult.setMessage(message);
        return responseResult;
    }

    public static ResponseResult ACCOUNT_NOT_LOGIN() {
        return new ResponseResult(ResponseState.ACCOUNT_NOT_LOGIN);
    }

    public static ResponseResult PERMISSION_DENIED() {
        return new ResponseResult(ResponseState.PERMISSION_DENIED);
    }

    public static ResponseResult FAILED() {
        return new ResponseResult(ResponseState.FAILED);
    }

    public static ResponseResult ACCOUNT_FORBID() {
        return new ResponseResult(ResponseState.ACCOUNT_FORBID);
    }

    public static ResponseResult FAILED(String message) {
        ResponseResult responseResult = new ResponseResult(ResponseState.FAILED);
        responseResult.setMessage(message);
        return responseResult;
    }

    public ResponseResult setData(Object data) {
        this.data = data;
        return this;
    }




}
