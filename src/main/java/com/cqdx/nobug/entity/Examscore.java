package com.cqdx.nobug.entity;

import java.io.Serializable;

/**
 * examscore
 * @author 
 */
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
@Data
public class Examscore  {
    @TableId
    private Integer examscoreid;

    private Integer studentid;

    private Integer courseid;

    private Integer score;

    private Integer credit;

    private String coursename;

}