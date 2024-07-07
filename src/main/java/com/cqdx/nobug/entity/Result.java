package com.cqdx.nobug.entity;


import lombok.Data;

@Data
public class Result<T> {

    /**
     * 请求是否成功
     * true:成功
     * false：失败
     */
    private boolean success;

    /**
     * 状态码
     * 成功：200
     * 失败：其他
     */
    private int code;

    /**
     * 失败状态码描述
     * 如果成功不返回
     * 失败返回状态码对应的msg消息
     */
    private String msg;

    /*总条数*/
    private long count;

    public Result(boolean success, int code) {
        this.setSuccess(success);
        this.setCode(code);
    }



    public Result(boolean success, int code, T data, long count) {
        this.setSuccess(success);
        this.setCode(code);
        this.setData(data);
        this.setCount(count);
    }
    public Result(boolean success, int code,  long count) {
        this.setSuccess(success);
        this.setCode(code);
        this.setCount(count);
    }
    public Result(boolean success, int code, String msg) {
        this.setSuccess(success);
        this.setCode(code);
        this.setMsg(msg);
    }

    //请求数据的结果

    private T data;

    public static <T> Result<T> success() {
        return new Result<T>(true, 200);
    }

    public static <T> Result<T> success(T data, long count) {
        return new Result<T>(true, 200, data, count);
    }
    public static <T> Result<T> success(long count) {
        return new Result<T>(true, 200,  count);
    }


    public static <T> Result<T> success(T data) {
        return new Result<T>(true, 200, data, 0);
    }


    public static <T> Result<T> fail(HttpStatusEnum httpStatusEnum) {
        return new Result<T>(false, httpStatusEnum.code(), httpStatusEnum.reasonPhraseUS());
    }

    public static <T> Result<T> fail(HttpStatusEnum httpStatusEnum, String msg) {
        return new Result<T>(false, httpStatusEnum.code(), msg);
    }

    public static <T> Result<T> fail(String msg) {
        return new Result<T>(false, HttpStatusEnum.INTERNAL_SERVER_ERROR.code(), msg);
    }
    public static <T> Result<T> success(String msg) {
        return new Result<T>(true, 200,msg);
    }


}

