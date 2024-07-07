package com.cqdx.nobug.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqdx.nobug.entity.Teacheraccount;
import com.cqdx.nobug.mapper.TeacheraccountDao;
import com.cqdx.nobug.service.TeacherAccountService;
import org.springframework.stereotype.Service;

@Service
public class TeacherAccountServiceImpl extends ServiceImpl<TeacheraccountDao, Teacheraccount> implements TeacherAccountService {
}
