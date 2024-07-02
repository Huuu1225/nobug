package com.cqdx.nobug.controller;
import com.cqdx.nobug.entity.Result;
import com.cqdx.nobug.entity.Teacheraccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/teacher")
public class TeacherAccountController {
    @Autowired
    private JdbcTemplate jdbc;
    @RequestMapping("/uniLogin")
    public Result doLogin(@RequestBody Teacheraccount tea){

        Result res = new Result();//多
        System.out.println("接收到的数据:");
        System.out.println(tea);
        try {
            Teacheraccount tmp = jdbc.queryForObject("select * from teacheraccount where TeacherId=? and Password=?",new BeanPropertyRowMapper<>(Teacheraccount.class),
                    tea.getTeacherid(),tea.getPassword());
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
}
