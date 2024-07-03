package com.cqdx.nobug.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqdx.nobug.entity.Studentinfo;
import com.cqdx.nobug.mapper.StudentinfoDao;
import com.cqdx.nobug.service.StudentInfoService;
import org.springframework.stereotype.Service;

@Service
public class StudentInfoServiceImpl extends ServiceImpl<StudentinfoDao, Studentinfo> implements StudentInfoService {
}
