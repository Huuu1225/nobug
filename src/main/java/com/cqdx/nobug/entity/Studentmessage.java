package com.cqdx.nobug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Studentmessage {
    @TableId(type = IdType.AUTO)
    private int MessageId;
    private int StudentId;
    private int TeacherId;
    private String StudentMessage;
    private String TeacherMessage;

}

