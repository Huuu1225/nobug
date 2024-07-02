package com.cqdx.nobug.entity;


import lombok.Data;
@Data
public class Result {
    private Integer code;  //200 正常   201 异常
    private Object result; //存整整的返回的数据
}
