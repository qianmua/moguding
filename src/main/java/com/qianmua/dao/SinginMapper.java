package com.qianmua.dao;

import com.qianmua.pojo.Singin;
import com.qianmua.pojo.SinginExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SinginMapper {

    long countByExample(SinginExample example);

    int deleteByExample(SinginExample example);

    int deleteByPrimaryKey(String id);

    int insert(Singin record);

    int insertSelective(Singin record);

    List<Singin> selectByExample(SinginExample example);

    Singin selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Singin record, @Param("example") SinginExample example);

    int updateByExample(@Param("record") Singin record, @Param("example") SinginExample example);

    int updateByPrimaryKeySelective(Singin record);

    int updateByPrimaryKey(Singin record);
}