package com.cqdx.nobug.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqdx.nobug.entity.Verification;
import com.cqdx.nobug.mapper.VerificationDao;
import com.cqdx.nobug.service.VerificationService;
import org.springframework.stereotype.Service;

@Service
public class VerificationServiceImpl extends ServiceImpl<VerificationDao, Verification> implements VerificationService {
}
