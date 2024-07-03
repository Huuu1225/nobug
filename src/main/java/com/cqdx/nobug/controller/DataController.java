package com.cqdx.nobug.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqdx.nobug.entity.Course;
import com.cqdx.nobug.entity.Examscore;
import com.cqdx.nobug.entity.Result;
import com.cqdx.nobug.entity.Studentinfo;
import com.cqdx.nobug.service.CourseService;
import com.cqdx.nobug.service.ExamscoreService;
import com.cqdx.nobug.service.StudentInfoService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@Mapper
@RestController("/data")
public class DataController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private ExamscoreService examscoreService;
    @Autowired
    private StudentInfoService studentInfoService;

    //后台
    //查看开设课程数目
    @GetMapping("/courseNum")
    public Result getCourseNum() {
        long totalUsers = courseService.count();
        return Result.success(totalUsers);
    }

    //查看挂科人次
    @GetMapping("/failNum")
    public Result getFailNum() {
        QueryWrapper<Examscore> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("Score", 60);
        long totalUsers = examscoreService.count(queryWrapper);
        return Result.success(totalUsers);
    }

    //查看合格人次
    @GetMapping("/passNum")
    public Result getPassNum() {
        QueryWrapper<Examscore> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("Score", 60);
        long totalUsers = examscoreService.count(queryWrapper);
        return Result.success(totalUsers);
    }

    //查看满绩人次
    @GetMapping("/fullNum")
    public Result getFullNum() {
        QueryWrapper<Examscore> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("Score", 90);
        long totalUsers = examscoreService.count(queryWrapper);
        return Result.success(totalUsers);
    }

    //查看学生人数
    @GetMapping("/studentNum")
    public Result getStudentNum() {
        long totalUsers = studentInfoService.count();
        return Result.success(totalUsers);
    }

    //查看男生人数
    @GetMapping("/maleNum")
    public Result getMaleNum() {
        QueryWrapper<Studentinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Gender", "男");
        long totalUsers = studentInfoService.count(queryWrapper);
        return Result.success(totalUsers);
    }

    //查看女生人数
    @GetMapping("/femaleNum")
    public Result getFemaleNum() {
        QueryWrapper<Studentinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Gender", "女");
        long totalUsers = studentInfoService.count(queryWrapper);
        return Result.success(totalUsers);
    }

    //查看课程对应所有分数，返回List
//    @GetMapping("/getCourseScore")
//    public List<Integer> getCourseScore(Integer courseid) {
//        QueryWrapper<Examscore> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("CourseId", courseid);
//        return examscoreService.listObjs(queryWrapper, obj -> ((Examscore) obj).getScore());
//    }

    @GetMapping("/getCourseScore")
    public List<Integer> getCourseScore(Integer courseid) {
        QueryWrapper<Examscore> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("CourseId", courseid);

        List<Examscore> examScores = examscoreService.list(queryWrapper);  // 获取 Examscore 对象的列表
        List<Integer> scores = examScores.stream()
                .map(Examscore::getScore)  // 提取成绩
                .collect(Collectors.toList());

        scores.sort(Integer::compareTo);

        return scores;
    }

}




