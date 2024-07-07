package com.cqdx.nobug.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cqdx.nobug.entity.Result;
import com.cqdx.nobug.entity.Studentaccount;
import com.cqdx.nobug.entity.Studentinfo;
import com.cqdx.nobug.service.StudentAccountService;
import com.cqdx.nobug.service.StudentInfoService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Mapper
@RestController("/info")
public class InfoController {
    @Autowired
    StudentInfoService studentInfoService;
    @Autowired
    StudentAccountService studentAccountService;
    //学生操作


    //修改电话号码
    @PostMapping("/student/modifyPhone")
    public Result modifyPhoneNumber(@RequestParam Integer studentid,@RequestParam String phone){
        UpdateWrapper<Studentinfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("StudentId",studentid).set("Phone",phone);
        boolean res = studentInfoService.update(updateWrapper);
        if(res){
            return Result.success();
        }
        else {
            return Result.fail("修改失败");
        }
    }

    //老师操作

    //增加学生信息
    @PostMapping("/teacher/addStudent")
    public Result<Studentinfo> addStudentInfo(@RequestBody Studentinfo studentinfo){
        boolean res = studentInfoService.save(studentinfo);
        if (res) {
            studentAccountService.save(new Studentaccount(studentinfo.getStudentid(),"123456"));
            return Result.success(studentinfo);
        }
        else return Result.fail("增加失败");
    }
    //更新学生信息
    @PostMapping("/teacher/updateStudent")
    public Result<Studentinfo> updateStudentInfo(@RequestBody Studentinfo studentinfo){
        boolean res = studentInfoService.updateById(studentinfo);
        if(res)return Result.success();
        else return Result.fail("更新失败");
    }
    //删除学生信息
    @PostMapping("/teacher/deleteStudent")
    public Result<Studentinfo> deleteStudentInfo(@RequestParam Integer studentid){
        boolean res = studentInfoService.removeById(studentid);
        if(res) {
            studentAccountService.removeById(studentid);
            return Result.success();
        }
        else return Result.fail("删除失败");
    }
    //批量删除学生信息
    @PostMapping("/teacher/deleteStudentList")
    public Result<Studentinfo> deleteStudentList(@RequestBody List<Integer> list) {
        boolean res = studentInfoService.removeByIds(list);
        if(res) {
            studentAccountService.removeByIds(list);
            return Result.success();
        }
        else return Result.fail("删除失败");
    }


    //根据id来查找学生
    @GetMapping("/getInfoById")
    public Result<Studentinfo> getById(@RequestParam Integer studentid) {
        System.out.println("studentid:"+studentid);
        Studentinfo studentInfo = studentInfoService.getById(studentid);
        if(studentInfo == null)return Result.fail("没有该学生");
        return Result.success(studentInfo);
    }
    //查看所有学生信息，根据页码返回对应学生，如页码1返回20220001-20220050个学生信息
    @GetMapping("/getInfoByPage")
    public Result<List<Studentinfo>> getAllStudentInfo(@RequestParam Integer page) {
        QueryWrapper<Studentinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("StudentId",(page-1)*50+20220000-1).lt("StudentId",page*50+20220000);
        long count = studentInfoService.count()/50;
        return Result.success(studentInfoService.list(queryWrapper), count);
    }
}
