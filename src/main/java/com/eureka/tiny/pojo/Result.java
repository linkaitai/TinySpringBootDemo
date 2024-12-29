package com.eureka.tiny.pojo;

import lombok.Data;
@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <E> Result<E> success(E data) {
        return new Result<>(0, "success", data);
    }

    public static Result success() {
        return new Result(0, "success", null);
    }

    public static Result error(String message) {
        return new Result(1, message, null);
    }

}


