package com.cqdx.nobug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.cqdx.nobug.entity.Email;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailDao extends BaseMapper<Email> {

}
