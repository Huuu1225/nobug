package com.cqdx.nobug.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * verification
 * @author 
 */
@Data
public class Verification implements Serializable {
    private String email;

    private String code;

    public Verification(String email, String code) {
        this.email = email;
        this.code = code;
    }
}