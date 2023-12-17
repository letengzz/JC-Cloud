package com.hjc.core.response;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.hjc.core.constant.HttpStatus;

/**
 * 统一响应实体类
 *
 * @param code    响应状态码
 * @param data    响应数据
 * @param message 响应消息
 * @param <T>     数据类型
 */
public record RespResult<T>(int code, T data, String message) {
    /**
     * 响应成功 携带数据
     * @param data 数据
     * @param <T>  数据格式
     * @return 统一响应格式
     */
    public static <T> RespResult<T> success(T data) {
        return new RespResult<>(HttpStatus.SUCCESS, data, "success");
    }

    /**
     * 响应成功
     * @param <T> 数据格式
     * @return 统一响应格式
     */
    public static <T> RespResult<T> success() {
        return success(null);
    }

    /**
     * 响应失败 携带状态码
     * @param code 失败状态码
     * @param message 失败信息
     * @return 统一响应格式
     * @param <T> 数据格式
     */
    public static <T> RespResult<T> failure(int code, String message) {
        return new RespResult<>(code, null, message);
    }

    /**
     *  响应失败
     * @param message 失败信息
     * @return 统一响应格式
     * @param <T> 数据格式
     */
    public static <T> RespResult<T> failure(String message) {
        return failure(HttpStatus.NOT_FOUND, message);
    }

    /**
     * 登录失败
     * @param message 失败信息
     * @return 统一响应格式
     * @param <T> 数据格式
     */
    public static <T>RespResult<T> unauthorized(String message) {
        return failure(HttpStatus.UNAUTHORIZED,message);
    }

    /**
     * 登录但未有权限
     * @param message 失败信息
     * @return 统一响应格式
     * @param <T> 数据格式
     */
    public static <T>RespResult<T> forbidden(String message) {
        return failure(HttpStatus.FORBIDDEN,message);
    }

    /**
     * 转换为Json格式
     * @return 返回数据
     */
    public String asJsonString(){
        return JSONObject.toJSONString(this, JSONWriter.Feature.WriteNulls);
    }
}
