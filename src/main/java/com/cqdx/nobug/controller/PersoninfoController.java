package com.cqdx.nobug.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cqdx.nobug.entity.Personinfo;
import com.cqdx.nobug.entity.Result;
import com.cqdx.nobug.service.PersoninfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/personinfo")
public class PersoninfoController {
    @Autowired
    private PersoninfoService personinfoService;

    //将unix的时间解码为string储存在数据库
    public static String timeStampToDate(String timestampString, String formats) {
        if (formats == null || formats.isEmpty()) {
            formats = "yyyy-MM-dd HH:mm:ss";
        }
        Long timestamp = Long.parseLong(timestampString);
        String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
        return date;
    }
    //得到数据
    @GetMapping("/getPersonInfoById")
    public Result<Personinfo> getPersonInfo(@RequestParam Integer studentid){
        QueryWrapper<Personinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("studentid",studentid);
        if(personinfoService.getOne(queryWrapper)!=null){
            return Result.success(personinfoService.getOne(queryWrapper));
        }else{
            return Result.fail("没有该学生信息");
        }

    }
    //返回数据保存在数据库
    @PostMapping("/savePersonInfo")
    public Result<Personinfo> savePersonInfo(@RequestBody Personinfo poi) {

        poi.setBirthday(timeStampToDate(poi.getBirthday().toString(),"yyyy-MM-dd HH:mm:ss"));
        UpdateWrapper<Personinfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("studentid",poi.getStudentid());
        personinfoService.update(poi,updateWrapper);
        return Result.success();

    }
}
