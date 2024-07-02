package com.cqdx.nobug.entity;


// 定义一个用于接收邮箱请求的数据类
import lombok.Data;
@Data
public class Email {
    private String email;
    // 省略构造方法和getter/setter方法

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
