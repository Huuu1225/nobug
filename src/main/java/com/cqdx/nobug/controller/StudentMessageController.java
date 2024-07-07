package com.cqdx.nobug.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqdx.nobug.entity.HttpStatusEnum;
import com.cqdx.nobug.entity.Result;
import com.cqdx.nobug.entity.Studentmessage;
import com.cqdx.nobug.service.StudentMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/studentmessages")
public class StudentMessageController {
    @Autowired
    public StudentMessageService studentMessageService;
    //根据学生ID查找学生留言及教师留言
//    @GetMapping("/getStudentMessageByStudentId/{StudentId}")
//    public Result<Studentmessage> getStudentMessageByStudentId(@PathVariable("StudentId") Integer StudentId) {
//        try {
//            List<Studentmessage> studentmessages = studentMessageService.getMessagebyStudentId(StudentId);
//            if (studentmessages.isEmpty()) {
//                return Result.fail(HttpStatusEnum.FORBIDDEN,"该学生没有留言记录");
//            } else {
//                Studentmessage studentmessageNew = studentmessages.get(0);
//                for (int i = 0; i < studentmessages.size(); i++) {
//                    if (studentmessages.get(i).getMessageId() > studentmessageNew.getMessageId()) {
//                        studentmessageNew = studentmessages.get(i);
//                    }
//                }
//                return Result.success(studentmessageNew);
//            }
//        }catch(DataAccessException e){
//            e.printStackTrace();
//            return Result.fail(HttpStatusEnum.FORBIDDEN,"存在异常"+e.getMessage());
//        }
//    }
    @GetMapping("/getStudentMessagesByStudentId/{StudentId}")
    public Result<List<Studentmessage>> getStudentMessagesByStudentId(@PathVariable("StudentId") Integer StundetId) {
            List<Studentmessage> studentmessages = studentMessageService.getMessagebyStudentId(StundetId);
            return Result.success(studentmessages);
    }
    //根据老师id查找学生留言及教师留言
    @GetMapping("/getStudentMessageByTeacherId/{TeacherId}")
    public Result<List<Studentmessage>> getStudentMessageByTeacherId(@PathVariable("TeacherId") Integer TeacherId) {
        try {
            List<Studentmessage> studentmessages = studentMessageService.getMessagebyTeacherId(TeacherId);
            if (studentmessages.isEmpty()) {
                return Result.fail(HttpStatusEnum.FORBIDDEN,"该老师没有留言记录");
            } else {
                return Result.success(studentmessages, studentmessages.size());
            }
        }catch(DataAccessException e){
            e.printStackTrace();
            return Result.fail(HttpStatusEnum.FORBIDDEN,"存在异常"+e.getMessage());
        }
    }
    //根据学生ID插入学生留言
    @PostMapping("/insertStudentMessage/{StudentId}")
    public Result<Studentmessage> insertStudentMessage(@PathVariable("StudentId") Integer StudentId, @RequestBody Studentmessage studentMessage) {
        try {
            int i = studentMessageService.insertStudentMessage(StudentId, studentMessage.getTeacherId(),studentMessage.getStudentMessage());
            if (i == 1) {
                return Result.success(studentMessage);
            } else {
                return Result.fail(HttpStatusEnum.FORBIDDEN,"插入失败");
            }
        }catch(DataAccessException e){
            e.printStackTrace();
            return Result.fail(HttpStatusEnum.FORBIDDEN,"存在异常"+e.getMessage());
        }
    }
    //根据老师id和学生id更新教师留言
    @PutMapping("updateTeacherMessage/{MessageId}")
    public Result<Studentmessage> updateTeacherMessage(@PathVariable("MessageId") Integer MessageId, @RequestBody Studentmessage studentMessage) {
        try {
            int i = studentMessageService.updateTeacherMessage(MessageId, studentMessage.getTeacherMessage());
            if (i == 1) {
                return Result.success(studentMessage);
            }else{
                return Result.fail(HttpStatusEnum.FORBIDDEN,"该留言不存在");
            }
        }catch(DataAccessException e){
            e.printStackTrace();
            return Result.fail(HttpStatusEnum.FORBIDDEN,"存在异常"+e.getMessage());
        }
    }
    //返回留言信息统计，用于数据可视化
    @GetMapping("/getStudentMessageCount")
    public Result<List<Integer>> getStudentMessageCount() {
        List<Studentmessage> studentmessages = studentMessageService.getStudentMessageCount();
        List<Integer> count = new ArrayList<>();
        count.add(studentmessages.size());
        int num1 = 0,num2=0;
        for (int i = 0; i < studentmessages.size(); i++) {
            if (studentmessages.get(i).getTeacherMessage() == null) {
                num1++;
            } else {
                num2++;
            }
        }
        count.add(num1);
        count.add(num2);
        return Result.success(count);
    }
    //根据待删除ID数组删除学生ID
    @PostMapping("/deleteStudentMessage")
    public Result<Studentmessage> deleteStudentMessage(@RequestBody List<Integer> MessageIds) {
        int count = 0;
        for (int i = 0; i < MessageIds.size(); i++) {
            int i1 = studentMessageService.deleteStudentMessage(MessageIds.get(i));
            count += i1;
        }
        if (count == MessageIds.size()) {
            return Result.success();
        } else {
            return Result.fail(HttpStatusEnum.FORBIDDEN,"删除失败");
        }
    }
    //获取用于数据可视化的留言数据
    @GetMapping("/getStudentMessageData")
    public Result<List<Studentmessage>> getStudentMessageData() {
        List<Studentmessage> studentmessages = studentMessageService.getStudentMessageCount();
        List<Studentmessage> studentMessagesdata = new ArrayList<>();
        for (int i = 0; i < studentmessages.size(); i++) {
            if (studentmessages.get(i).getTeacherMessage() == null) {
                int len= studentmessages.get(i).getStudentMessage().length();
                studentmessages.get(i).setStudentMessage(studentmessages.get(i).getStudentMessage().substring(0, len>10?10:len));
                studentMessagesdata.add(studentmessages.get(i));
            }
        }
        return Result.success(studentMessagesdata);
    }
    //统计学生留言人数排行榜
    @GetMapping("/getStudentMessageRank")
    public Result<List<Map.Entry<Integer, Long>>> getStudentMessageRank() {
        List<Studentmessage> studentmessages = studentMessageService.getStudentMessageCount();
        // 使用Stream API统计studentIds中各ID的出现次数
        Map<Integer, Long> idCounts = studentmessages.stream()
                .map(Studentmessage::getStudentId)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // 对统计结果按出现次数降序排序
        List<Map.Entry<Integer, Long>> sortedIdCounts = idCounts.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .collect(Collectors.toList());
        return Result.success(sortedIdCounts);
    }
}