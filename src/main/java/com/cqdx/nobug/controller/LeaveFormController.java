package com.cqdx.nobug.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqdx.nobug.entity.Leaveform;
import com.cqdx.nobug.entity.Result;
import com.cqdx.nobug.service.LeaveFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/leaveforms")
public class LeaveFormController {

    /**
     * Java将Unix时间戳转换成指定格式日期字符串
     * @param timestampString 时间戳 如："1473048265";
     * @return 返回结果 如："2016-09-05 16:06:42";
     */
    public static String timeStampToDate(String timestampString, String formats) {
        if (formats == null || formats.isEmpty()) {
            formats = "yyyy-MM-dd HH:mm:ss";
        }
        Long timestamp = Long.parseLong(timestampString);
        String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
        return date;
    }



    @Autowired
    private LeaveFormService leaveFormService;

    @PostMapping("/insertLeaveForm")
    public Result insertLeaveForm(@RequestBody Leaveform leaveForm) {
        leaveForm.setStarttime(timeStampToDate(leaveForm.getStarttime().toString(),"yyyy-MM-dd HH:mm:ss"));
        leaveForm.setEndtime(timeStampToDate(leaveForm.getEndtime().toString(),"yyyy-MM-dd HH:mm:ss"));
        // 保存请假表单数据
        leaveFormService.save(leaveForm);

        // 如果成功，返回成功消息
        return  Result.success("发送成功");
    }
    @GetMapping("/getLeaveForm")
    public Result<List<Leaveform>> getLeaveForm(int studentid) {
        QueryWrapper<Leaveform> leaveformQueryWrapper = new QueryWrapper<>();
        leaveformQueryWrapper.eq("studentid",studentid);
        return Result.success(leaveFormService.list(leaveformQueryWrapper));

    }
    //获取所有请假结果
    @GetMapping("/getAllLeaveForm")
    public Result<List<Leaveform>> getAllLeaveForm() {
        return Result.success(leaveFormService.list());
    }
    //批量删除请假数据
    @PostMapping("/deleteLeaveForm")
    public Result deleteLeaveForm(@RequestBody List<Integer> list) {
        leaveFormService.removeByIds(list);
        return Result.success();
    }

}

