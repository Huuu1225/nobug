package com.cqdx.nobug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqdx.nobug.entity.Personinfo;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersoninfoDao extends BaseMapper<Personinfo> {
    int deleteByPrimaryKey(Integer studentid);

    int insert(Personinfo record);

    int insertSelective(Personinfo record);

    Personinfo selectByPrimaryKey(Integer studentid);

    int updateByPrimaryKeySelective(Personinfo record);

    int updateByPrimaryKey(Personinfo record);
}