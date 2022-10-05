package me.lazychildren.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    private String msg;
    private Object data;
    private Integer code;

    public static Result success(Object obj)
    {
        return new Result("success", obj, 200);
    }

    public static Result fail(String message)
    {
        return new Result(message,null, 400);
    }
}
