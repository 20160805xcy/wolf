package com.xcy.wolf.service;

import com.xcy.wolf.model.CustomerChild;
import com.xcy.wolf.qo.CustomerQo;
import com.xcy.wolf.wrapper.BackResult;

import java.util.List;

/**
 * @author xcy
 * @date 2018/11/15 14:54
 * @description CustomerChildService
 * @since V1.0.0
 */
public interface CustomerChildService {

    List<CustomerChild> listAllCustomer();

    CustomerChild selectByLogInNameAndPassWord(String loginName, String passWord);

    Object listByPage(CustomerQo qo);

    CustomerChild selectById(Integer id);
}
