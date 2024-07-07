package com.cqdx.nobug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqdx.nobug.entity.Leaveform;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LeaveFormDao extends BaseMapper<Leaveform> {
    int deleteByPrimaryKey(String studentId);

    int insert(Leaveform record);

    int insertSelective(Leaveform record);

    Leaveform selectByPrimaryKey(String studentId);

    int updateByPrimaryKeySelective(Leaveform record);

    int updateByPrimaryKey(Leaveform record);
}