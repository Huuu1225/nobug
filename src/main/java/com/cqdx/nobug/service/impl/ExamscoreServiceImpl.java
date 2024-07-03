package com.cqdx.nobug.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqdx.nobug.entity.Examscore;
import com.cqdx.nobug.mapper.ExamscoreDao;
import com.cqdx.nobug.service.ExamscoreService;
import org.springframework.stereotype.Service;

@Service
public class ExamscoreServiceImpl extends ServiceImpl<ExamscoreDao, Examscore> implements ExamscoreService {
}
