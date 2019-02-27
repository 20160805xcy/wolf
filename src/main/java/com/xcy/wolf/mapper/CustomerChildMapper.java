package com.xcy.wolf.mapper;

import com.xcy.wolf.model.CustomerChild;
import com.xcy.wolf.util.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface CustomerChildMapper extends MyMapper<CustomerChild> {

    CustomerChild selectByLogInNameAndPassWord(@Param("loginName")String loginName,  @Param("passWord") String passWord);
}