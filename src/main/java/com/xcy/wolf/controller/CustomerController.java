package com.xcy.wolf.controller;

import com.github.pagehelper.PageInfo;
import com.xcy.wolf.model.CustomerChild;
import com.xcy.wolf.qo.CustomerQo;
import com.xcy.wolf.service.CustomerChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author xcy
 * @date 2018/11/15 14:51
 * @description customerController
 * @since V1.0.0
 */
@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerChildService customerChildService;

    @RequestMapping("toListAllCustomer")
    public String toListAllCustomer(Model model, CustomerQo qo){
        //List<CustomerChild> customerChildList = customerChildService.listAllCustomer();
        PageInfo page = (PageInfo) customerChildService.listByPage(qo);
        System.out.println("======");
        model.addAttribute("total", page.getTotal());
        model.addAttribute("pages", page.getPages());
        model.addAttribute("pageNum", page.getPageNum());
        model.addAttribute("customerChildList", page);
        return "listAllCustomer";
    }


    @RequestMapping("listAllCustomer")
    public List<CustomerChild> listAllCustomer(){
        List<CustomerChild> customerChildList = customerChildService.listAllCustomer();
        return customerChildList;
    }
}
