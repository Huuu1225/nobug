package com.cqdx.nobug.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqdx.nobug.entity.*;
import com.cqdx.nobug.service.EmailService;
import com.cqdx.nobug.service.StudentAccountService;
import com.cqdx.nobug.service.VerificationService;
import com.cqdx.nobug.temp.Account;
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

    @PostMapping("/uniLogin")
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
    //未登录时修改密码，需要通过邮箱验证
    @PostMapping("/modify")
    public Result modify(@RequestBody Account account) {
    // 检查密码是否为空
    if (account.getPassword1()==null || account.getPassword2()==null || account.getPassword1().isEmpty() || account.getPassword2().isEmpty()) {
        return Result.fail("密码不能为空");
    }

    // 检查密码是否一致
    if (!account.getPassword1().equals(account.getPassword2())) {
        return Result.fail("两次密码不一致");
    }

    // 检查邮箱是否为空
    if (account.getEmail() == null || account.getEmail().isEmpty()) {
        return Result.fail("邮箱不能为空");
    }

    // 检查验证码是否为空
    if (account.getCode() == null || account.getCode().isEmpty()) {
        return Result.fail("验证码不能为空");
    }
    // 查询验证码
    QueryWrapper<Verification> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("email", account.getEmail());
    Verification verification = verificationService.getOne(queryWrapper);

    // 检查验证码是否正确
    if (verification == null || !account.getCode().equals(verification.getCode())) {
        return Result.fail("验证码错误");
    }

    // 更新学生账户密码
    UpdateWrapper<Studentaccount> updateWrapper = new UpdateWrapper<>();
    updateWrapper.eq("StudentId",account.getStudentid()).set("Password",account.getPassword1());
    boolean res=studentAccountService.update(updateWrapper);
    if(res){
        return Result.success("成功");
    }else {
        return Result.fail("更新失败");
    }

    }

    //登录后修改密码，直接修改
    @PostMapping("/modify2")
    public Result modify2(@RequestParam Integer studentid,@RequestParam String password) {
        UpdateWrapper<Studentaccount> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("StudentId",studentid).set("Password",password);
        if(studentAccountService.update(updateWrapper)){
            return Result.success("成功");
        }else {
            return Result.fail("更新失败");
        }

    }

    @GetMapping("/getListPage")
    public Result<List<Studentaccount>> getStudentAccounts()
    {
        IPage<Studentaccount> page = new Page<>(1, 2);
        IPage<Studentaccount> stuPage = studentAccountService.page(page); // 调用 page 方法
        List<Studentaccount> list = stuPage.getRecords();
        return Result.success(list);
    }
}
