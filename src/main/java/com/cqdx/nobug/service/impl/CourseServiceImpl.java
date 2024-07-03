package com.cqdx.nobug.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqdx.nobug.entity.Course;
import com.cqdx.nobug.mapper.CourseDao;
import com.cqdx.nobug.service.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseDao,Course> implements CourseService {

}
