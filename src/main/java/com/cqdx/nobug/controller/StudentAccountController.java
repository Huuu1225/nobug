package com.cqdx.nobug.controller;

import com.cqdx.nobug.entity.Result;
import com.cqdx.nobug.entity.Studentaccount;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentAccountController {

    @Autowired
    private JdbcTemplate jdbc;
//
//    @Autowired
//    private StudentAccountService studentAccountService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/uniLogin")
    public Result doLogin(@RequestBody Studentaccount stu){

        Result res = new Result();//多
        System.out.println("接收到的数据:");
        System.out.println(stu);
        try {
            Studentaccount tmp = jdbc.queryForObject("select * from studentaccount where StudentId=? and Password=?",new BeanPropertyRowMapper<>(Studentaccount.class),
                    stu.getStudentid(),stu.getPassword());
            res.setCode(200);
            res.setResult(tmp);//用户数据放入结果中
            return res;
        } catch (DataAccessException e) {
            e.printStackTrace();
            res.setCode(201);
            res.setResult("出现异常"+e.getMessage());//message 异常的信息
            return res;
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
