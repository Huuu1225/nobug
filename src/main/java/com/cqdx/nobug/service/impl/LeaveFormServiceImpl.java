package com.cqdx.nobug.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqdx.nobug.entity.Leaveform;
import com.cqdx.nobug.mapper.LeaveFormDao;
import com.cqdx.nobug.service.LeaveFormService;
import org.springframework.stereotype.Service;

@Service
public class LeaveFormServiceImpl extends ServiceImpl<LeaveFormDao, Leaveform> implements LeaveFormService {
}

