package com.xcy.wolf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xcy.wolf.mapper.CustomerChildMapper;
import com.xcy.wolf.model.CustomerChild;
import com.xcy.wolf.qo.CustomerQo;
import com.xcy.wolf.service.CustomerChildService;
import com.xcy.wolf.util.Base64Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xcy
 * @date 2018/11/15 14:55
 * @description CustomerChildServiceImpl
 * @since V1.0.0
 */
@Service("customerChildService")
public class CustomerChildServiceImpl implements CustomerChildService {

    @Autowired
    CustomerChildMapper customerChildMapper;


    @Override
    public List<CustomerChild> listAllCustomer() {
        List<CustomerChild> customerChildList = customerChildMapper.selectAll();
        //CustomerChild customerChild = new CustomerChild();
        //customerChild.setCustomerId(602);
        ////List<CustomerChild> customerChildList =
        //
        //CustomerChild customerChild1 = customerChildMapper.selectOne(customerChild);
        //ArrayList<CustomerChild> arrayList = new ArrayList<>();
        //arrayList.add(customerChild1);
        //customerChild.setCustomerId(603);
        //CustomerChild customerChild2 = customerChildMapper.selectOne(customerChild);
        //arrayList.add(customerChild2);

        return customerChildList;
    }

    @Override
    public Object listByPage(CustomerQo qo) {
        PageHelper.startPage(qo.getPage(), qo.getLimit());
        List<CustomerChild> customerChildList = customerChildMapper.selectAll();
        return new PageInfo<CustomerChild>(customerChildList);
    }

    @Override
    public CustomerChild selectById(Integer id) {
        return customerChildMapper.selectByPrimaryKey(id);
    }

    @Override
    public CustomerChild selectByLogInNameAndPassWord(String loginName, String passWord) {
        String passWordBae64 = Base64Utils.getBase64(passWord);
        return customerChildMapper.selectByLogInNameAndPassWord(loginName, passWordBae64);
    }
}
