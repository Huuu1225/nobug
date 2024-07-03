package com.cqdx.nobug.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * verification
 * @author 
 */
@Data
public class Verification implements Serializable {
    @TableId
    private String email;

    private String code;

    public Verification(String email, String code) {
        this.email = email;
        this.code = code;
    }
}