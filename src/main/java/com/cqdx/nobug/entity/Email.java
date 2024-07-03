package com.cqdx.nobug.entity;


// 定义一个用于接收邮箱请求的数据类
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
@Data
public class Email {
    @TableId
    private String email;
    // 省略构造方法和getter/setter方法

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
