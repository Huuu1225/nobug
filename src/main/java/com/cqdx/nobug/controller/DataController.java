package com.cqdx.nobug.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqdx.nobug.entity.*;
import com.cqdx.nobug.service.CourseService;
import com.cqdx.nobug.service.ExamscoreService;
import com.cqdx.nobug.service.LeaveFormService;
import com.cqdx.nobug.service.StudentInfoService;
import com.cqdx.nobug.temp.DormitoryCount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
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
    @Autowired
    private LeaveFormService leaveFormService;

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

    //根据课程id返回各分数段的人数
    @GetMapping("/getScoreNum")
    public Result<List<Long>> getScoreNum(Integer courseId) {
        List<Long> scoreCounts = new ArrayList<>(10); // 初始化一个大小为10的列表，用于存放每个分数段的人数
        for (int i = 0; i < 10; i++) {
            // 初始化每个循环的计数为0
            long count = 0;
            // 构建针对当前分数段的查询条件
            QueryWrapper<Examscore> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("CourseId", courseId)
                    .ge("Score", i * 10) // 分数段的起始值
                    .lt("Score", (i + 1) * 10); // 分数段的结束值（不包含）
            // 执行查询并获取满足条件的记录数
            count = examscoreService.count(queryWrapper);
            // 将计数添加到结果列表中
            scoreCounts.add(count);
        }
        // 返回结果
        return Result.success(scoreCounts);
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
    //查看寝室为兰园的男生人数
    @GetMapping("/getLanMale")
    public Result getLanMale() {
        QueryWrapper<Studentinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Dormitory", "兰园").eq("Gender", "男");
        long totalUsers = studentInfoService.count(queryWrapper);
        return Result.success(totalUsers);
    }

    //查看寝室为兰园的女生
    @GetMapping("/getLanFemale")
    public Result getLanFemale() {
        QueryWrapper<Studentinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Dormitory", "兰园").eq("Gender", "女");
        long totalUsers = studentInfoService.count(queryWrapper);
        return Result.success(totalUsers);
    }

    //查看寝室为梅园的男生
    @GetMapping("/getMeiMale")
    public Result getMeiMale() {
        QueryWrapper<Studentinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Dormitory", "梅园").eq("Gender", "男");
        long totalUsers = studentInfoService.count(queryWrapper);
        return Result.success(totalUsers);
    }

    //查看寝室为梅园的女生
    @GetMapping("/getMeiFemale")
    public Result getMeiFemale() {
        QueryWrapper<Studentinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Dormitory", "梅园").eq("Gender", "女");
        long totalUsers = studentInfoService.count(queryWrapper);
        return Result.success(totalUsers);
    }

    //查看寝室为竹园的男生
    @GetMapping("/getZhuMale")
    public Result getZhuMale() {
        QueryWrapper<Studentinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Dormitory", "竹园").eq("Gender", "男");
        long totalUsers = studentInfoService.count(queryWrapper);
        return Result.success(totalUsers);
    }

    //查看寝室为竹园的女生
    @GetMapping("/getZhuFemale")
    public Result getZhuFemale() {
        QueryWrapper<Studentinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Dormitory", "竹园").eq("Gender", "女");
        long totalUsers = studentInfoService.count(queryWrapper);
        return Result.success(totalUsers);
    }

    //查看寝室为松园的男生
    @GetMapping("/getSongMale")
    public Result getSongMale() {
        QueryWrapper<Studentinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Dormitory", "松园").eq("Gender", "男");
        long totalUsers = studentInfoService.count(queryWrapper);
        return Result.success(totalUsers);
    }

    //查看寝室为松园的女生
    @GetMapping("/getSongFemale")
    public Result getSongFemale() {
        QueryWrapper<Studentinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Dormitory", "松园").eq("Gender", "女");
        long totalUsers = studentInfoService.count(queryWrapper);
        return Result.success(totalUsers);
    }
    @GetMapping("/getAllDormitoryCounts")
    public Result getAllDormitoryCounts() {
        List<String> dormitories = Arrays.asList("兰园", "梅园", "竹园", "松园");
        List<String> genders = Arrays.asList("男", "女");
        List<DormitoryCount> counts = new ArrayList<>();

        for (String dormitory : dormitories) {
            for (String gender : genders) {
                QueryWrapper<Studentinfo> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("Dormitory", dormitory).eq("Gender", gender);
                long totalUsers = studentInfoService.count(queryWrapper);

                DormitoryCount count = new DormitoryCount();
                count.setDormitory(dormitory);
                count.setGender(gender);
                count.setTotalUsers(totalUsers);

                counts.add(count);
            }
        }

        return Result.success(counts);
    }

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
    //请假人数
    //返回请假未审批人数与已审批人数
    @GetMapping("/getLeaveFormCount")
    public Result<List<Long>> getLeaveFormCount() {
        List<Long> scoreCounts = new ArrayList<>(2); // 初始化一个大小为10的列表，用于存放每个分数段的人数
        long count = 0;
        for (int i = 0; i < 2; i++) {
            QueryWrapper<Leaveform> queryWrapper = new QueryWrapper<>();
            switch (i) {
                case 0:
                    queryWrapper.eq("approval", 0);
                    count = leaveFormService.count(queryWrapper);
                    break;
                case 1:
                    count=leaveFormService.count()-count;
                    break;
            }
            scoreCounts.add(count);
        }
        // 返回结果
        return Result.success(scoreCounts);
    }

}




