package com.cqdx.nobug.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cqdx.nobug.entity.HttpStatusEnum;
import com.cqdx.nobug.entity.Result;
import com.cqdx.nobug.entity.Studentaccount;
import com.cqdx.nobug.entity.Teacheraccount;
import com.cqdx.nobug.service.TeacherAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/teacher")
public class TeacherAccountController {
    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private TeacherAccountService teaService;
    @PostMapping("/uniLogin")
    public Result<Teacheraccount> doLogin(@RequestBody Teacheraccount tea){

        System.out.println("接收到的数据:");
        System.out.println(tea);
        try {
            Teacheraccount tmp = jdbc.queryForObject("select * from teacheraccount where TeacherId=? and Password=?",new BeanPropertyRowMapper<>(Teacheraccount.class),
                    tea.getTeacherid(),tea.getPassword());
            return  Result.success(tmp);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return Result.fail(HttpStatusEnum.FORBIDDEN,"出现异常"+e.getMessage());
        }
    }
    //老师账号修改密码
    @PostMapping("/modifyPassword")
    public Result<Teacheraccount> modifyPassword(@RequestBody Teacheraccount tea){
        UpdateWrapper<Teacheraccount> upWrapper = new UpdateWrapper<>();
        upWrapper.eq("teacherid",tea.getTeacherid()).set("password",tea.getPassword());
        teaService.update(upWrapper);
        return Result.success();

    }

}
