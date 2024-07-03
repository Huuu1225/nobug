package com.cqdx.nobug.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqdx.nobug.entity.Studentaccount;
import com.cqdx.nobug.mapper.StudentAccountDao;
import com.cqdx.nobug.service.StudentAccountService;
import org.springframework.stereotype.Service;

@Service
public class StudentAccountServiceImpl extends ServiceImpl<StudentAccountDao, Studentaccount> implements StudentAccountService{


}

