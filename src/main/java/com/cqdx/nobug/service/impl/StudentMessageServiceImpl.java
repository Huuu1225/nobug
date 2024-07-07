package com.cqdx.nobug.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqdx.nobug.mapper.StudentMassageDao;
import com.cqdx.nobug.entity.Studentmessage;
import com.cqdx.nobug.service.StudentMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentMessageServiceImpl extends ServiceImpl<StudentMassageDao, Studentmessage> implements StudentMessageService {
    @Autowired
    public StudentMassageDao studentMassageDao;
    //根据学生id查询学生留言
    public List<Studentmessage> getMessagebyStudentId(Integer studentId)
    {
        return studentMassageDao.getMessagebyStudentId(studentId);
    }
    //根据老师id查询学生留言
    public List<Studentmessage> getMessagebyTeacherId(Integer teacherId)
    {
        return studentMassageDao.getMessagebyTeacherId(teacherId);
    }
    //插入学生留言
    public int insertStudentMessage(Integer studentId,Integer teacherId,String studentMessage)
    {
        return studentMassageDao.insertStudentMessage(studentId,teacherId,studentMessage);
    }
    //更新老师留言
    public int updateTeacherMessage(Integer messageId,String teacherMessage)
    {
        return studentMassageDao.updateTeacherMessage(messageId,teacherMessage);
    }
    //统计留言信息
    public List<Studentmessage> getStudentMessageCount()
    {
        return studentMassageDao.getStudentMessageCount();
    }
    //删除留言信息
    public int deleteStudentMessage(Integer messageId)
    {
        return studentMassageDao.deleteStudentMessage(messageId);
    }
}
