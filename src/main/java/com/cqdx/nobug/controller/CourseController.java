package com.cqdx.nobug.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cqdx.nobug.entity.Course;
import com.cqdx.nobug.entity.Examscore;
import com.cqdx.nobug.entity.Result;
import com.cqdx.nobug.service.CourseService;
import com.cqdx.nobug.service.ExamscoreService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Mapper
@RestController("/course")
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    ExamscoreService examscoreService ;
    //成绩
    //学生

    //成绩查询
    @GetMapping("/student/getscore")
    public Result<List<Examscore>> stuGetScore(Integer studentId) {
        QueryWrapper<Examscore> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("StudentId", studentId);
        List<Examscore> examscores=examscoreService.list(queryWrapper);
        if (examscores.isEmpty())return Result.success("成绩为空");
        else return Result.success(examscores);
    }

    //老师

    //成绩查询
    @GetMapping("/teacher/getscore")
    public Result<List<Examscore>> TeaGetScore() {
        return Result.success(examscoreService.list());
    }

    //成绩录入
    @PostMapping("/teacher/setscore")
    public Result<Examscore> TeaSetScore(@RequestBody Examscore examscore) {
        boolean b = examscoreService.save(examscore);
        if (b) {
            return Result.success(examscore);
        }else {
            return Result.fail("成绩录入失败");
        }

    }

    //成绩修改
    @PostMapping("/teacher/modifyscore")
    public Result<Examscore> TeaModifyScore(@RequestBody Examscore examscore) {
        boolean b = examscoreService.updateById(examscore);
        if (b) {
            return Result.success(examscore);
        }else {
            return Result.fail("成绩修改失败");
        }

    }

    //成绩删除
    @PostMapping("/teacher/deletescore")
    public Result<Examscore> TeaDeleteScore(@RequestBody Examscore examscore) {
        boolean b = examscoreService.removeById(examscore);
        if (b) {
            return Result.success("成绩删除成功");
        }else {
            return Result.fail("成绩删除失败");
        }
    }


    //Examscore
    //学生

    //查询已修课程
    @GetMapping("/student/getCompletedCourse")
    public Result<List<Examscore>> getRepairedCourse(Integer studentId){
        QueryWrapper<Examscore> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("StudentId", studentId).gt("Score",-1);
        List<Examscore>   list=examscoreService.list(queryWrapper);
        if (list.isEmpty()) return Result.success("未查询到已修课程");
        else return Result.success(list);
    }
    //在修课程
    @GetMapping("/student/getTakingCourse")
    public Result<List<Examscore>> getTakingCourse(Integer studentId){
        QueryWrapper<Examscore> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("StudentId", studentId).eq("Score",-1);
        List<Examscore>   list=examscoreService.list(queryWrapper);
        if (list.isEmpty()) return Result.success("未查询到在修课程");
        else return Result.success(list);

    }


    //课程
    //老师

    //增加课程
    @PostMapping("/teacher/addCourse")
    public Result<Course> addCourse(@RequestBody Course course) {
        boolean b = courseService.save(course);
        if (b) {
            return Result.success(course);
        }else {
            return Result.fail("课程添加失败");
        }
    }

    //删除课程
    @PostMapping("/teacher/deleteCourse")
    public Result<Course> deleteCourse(@RequestBody Course course) {
        boolean b = courseService.removeById(course);
        if (b) {
            return Result.success("课程删除成功");
        }else {
            return Result.fail("课程删除失败");
        }
    }

    //查询课程
    @GetMapping("/teacher/getCourse")
    public Result<List<Course>> getCourse(){
        List<Course> list=courseService.list();
        if (list.isEmpty()) return Result.success("未查询到课程");
        else return Result.success(list);
    }

    //修改课程
    @PostMapping("/teacher/modifyCourse")
    public Result<Course> modifyCourse(@RequestBody Course course) {
        boolean b = courseService.updateById(course);
        if (b) {
            return Result.success(course);
        }else {
            return Result.fail("课程修改失败");
        }
    }



}
