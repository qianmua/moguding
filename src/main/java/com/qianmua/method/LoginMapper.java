package com.qianmua.method;

import com.qianmua.entity.Login;
import com.qianmua.entity.LoginExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginMapper {

    long countByExample(LoginExample example);

    int deleteByExample(LoginExample example);

    int deleteByPrimaryKey(String id);

    int insert(Login record);

    int insertSelective(Login record);

    List<Login> selectByExample(LoginExample example);

    Login selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Login record, @Param("example") LoginExample example);

    int updateByExample(@Param("record") Login record, @Param("example") LoginExample example);

    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login record);

    //   查询所有登录信息
    List<Login> selectAll();
}