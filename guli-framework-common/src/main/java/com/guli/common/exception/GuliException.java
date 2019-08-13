package com.guli.common.exception;

import com.guli.common.constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("全局异常")
public class GuliException extends RuntimeException {

    private Integer code;

    /**
     * 接收状态码和消息
     */
    public GuliException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类型
     */
    public GuliException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "GuliException{" +
                "message=" + this.getMessage() +
                ", code=" + code +
                '}';
    }

}
