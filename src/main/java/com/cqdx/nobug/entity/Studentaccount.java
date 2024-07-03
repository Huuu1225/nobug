package com.cqdx.nobug.entity;

import java.io.Serializable;

/**
 * studentaccount
 * @author 
 */
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
@Data
public class Studentaccount  {
    @TableId
    private Integer studentid;

    private String password;
    public Studentaccount(){}

    public Studentaccount(Integer studentid, String password) {
        this.studentid = studentid;
        this.password = password;
    }
}