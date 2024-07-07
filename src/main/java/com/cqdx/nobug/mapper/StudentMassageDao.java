package com.cqdx.nobug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqdx.nobug.entity.Studentmessage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMassageDao extends BaseMapper<Studentmessage> {
    //根据学生id查询学生留言及老师留言
    @Select("select * from studentmessage where studentid = #{StudentId}")
    List<Studentmessage> getMessagebyStudentId(@Param("StudentId") Integer StudentId);
    //根据老师id查询学生留言及老师留言
    @Select("select * from studentmessage where teacherid = #{TeacherId}")
    List<Studentmessage> getMessagebyTeacherId(@Param("TeacherId") Integer TeacherId);
    //存储学生留言
    @Insert("insert into studentmessage(studentid,teacherid,studentmessage) values(#{StudentId},#{TeacherId},#{Studentmessage})")
    int insertStudentMessage(@Param("StudentId") Integer StudentId,@Param("TeacherId") Integer TeacherId,@Param("Studentmessage") String StudentMessage);
    //根据留言id修改老师留言信息
    @Update("update studentmessage set teachermessage = #{TeacherMessage} where messageid =#{MessageId}")
    int updateTeacherMessage(@Param("MessageId") Integer MessageId,@Param("TeacherMessage") String TeacherMessage);
    //获取留言统计
    @Select("select * from studentmessage")
    List<Studentmessage> getStudentMessageCount();
    //根据留言ID删除学生留言信息
    @Delete("delete from studentmessage where messageid = #{MessageId}")
    int deleteStudentMessage(@Param("MessageId") Integer MessageId);
}

