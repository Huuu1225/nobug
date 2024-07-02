package com.cqdx.nobug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqdx.nobug.entity.Teacheraccount;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface TeacheraccountDao extends BaseMapper<Teacheraccount> {


    int deleteByPrimaryKey(Integer teacherid);

    int insert(Teacheraccount record);

    int insertSelective(Teacheraccount record);

    Teacheraccount selectByPrimaryKey(Integer teacherid);

    int updateByPrimaryKeySelective(Teacheraccount record);

    int updateByPrimaryKey(Teacheraccount record);
}