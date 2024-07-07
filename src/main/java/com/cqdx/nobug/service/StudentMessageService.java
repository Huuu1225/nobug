package com.cqdx.nobug.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqdx.nobug.entity.Studentmessage;

import java.util.List;

public interface StudentMessageService extends IService<Studentmessage> {
    //根据学生id查询学生留言
    List<Studentmessage> getMessagebyStudentId(Integer studentId);
    //根据老师id查询学生留言
    List<Studentmessage> getMessagebyTeacherId(Integer teacherId);
    //根据学生id插入学生留言
    int insertStudentMessage(Integer studentId,Integer TeacherId,String studentMessage);
    //根据老师学生id更新学生留言
    int updateTeacherMessage(Integer messageId,String teacherMessage);
    //统计留言信息
    List<Studentmessage> getStudentMessageCount();
    //删除留言信息
    int deleteStudentMessage(Integer MessageId);
}
