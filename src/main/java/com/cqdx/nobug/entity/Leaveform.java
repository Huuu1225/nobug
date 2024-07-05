package com.cqdx.nobug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@TableName("leaveform")
public class Leaveform {
    @TableId(type= IdType.AUTO)
    private  int leaveformid;
    private int studentid;
    private String leavereason;
    private String starttime; // 使用 LocalDateTime 类型
    private String endtime;   // 使用 LocalDateTime 类型
    private int approval;
    private int teacherid;


}