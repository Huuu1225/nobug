package com.cqdx.nobug.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqdx.nobug.entity.Personinfo;
import com.cqdx.nobug.mapper.PersoninfoDao;
import com.cqdx.nobug.service.PersoninfoService;
import org.springframework.stereotype.Service;

@Service
public class PersoninfoServiceImpl extends ServiceImpl<PersoninfoDao, Personinfo> implements PersoninfoService {
}
