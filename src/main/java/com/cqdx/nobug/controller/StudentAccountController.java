package com.cqdx.nobug.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqdx.nobug.entity.*;
import com.cqdx.nobug.service.EmailService;
import com.cqdx.nobug.service.StudentAccountService;
import com.cqdx.nobug.service.VerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentAccountController {

    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    private StudentAccountService studentAccountService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private VerificationService verificationService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/uniLogin")
    public Result<Studentaccount> doLogin(@RequestBody Studentaccount stu){

        System.out.println("接收到的数据:");
        System.out.println(stu);
        try {
            Studentaccount tmp = jdbc.queryForObject("select * from studentaccount where StudentId=? and Password=?",new BeanPropertyRowMapper<>(Studentaccount.class),
                    stu.getStudentid(),stu.getPassword());
            return Result.success(tmp);//用户数据放入结果中
        } catch (DataAccessException e) {
            e.printStackTrace();
            return  Result.fail(HttpStatusEnum.FORBIDDEN,"出现异常"+e.getMessage());
        }
    }
//    @PostMapping("/modify")
//    public Result modify(int StudentId,String Password1,String Password2,String code){
//        Result result = new Result();
//
//        if(Password1 == null || Password2 == null||Password1.equals(Password2)){
//
//        }
//    }



}
