package com.xcy.wolf.controller;

import com.github.pagehelper.PageInfo;
import com.xcy.wolf.qo.CustomerQo;
import com.xcy.wolf.service.CustomerChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping
    public ModelAndView getAll(CustomerQo qo) {
        ModelAndView result = new ModelAndView("listAllCustomer");
        PageInfo page = (PageInfo) customerChildService.listByPage(qo);
        result.addObject("pageInfo", page.getList());
        result.addObject("page", page.getPageNum());
        result.addObject("rows", page.getPageSize());
        result.addObject("customerChildList", page);
        System.out.println("hello");
        return result;
    }

    @RequestMapping("toListAllCustomer")
    public String toListAllCustomer(Model model, CustomerQo qo){
        //List<CustomerChild> customerChildList = customerChildService.listAllCustomer();
        PageInfo page = (PageInfo) customerChildService.listByPage(qo);
        model.addAttribute("total", page.getTotal());
        model.addAttribute("pages", page.getPages());
        model.addAttribute("pageNum", page.getPageNum());
        model.addAttribute("customerChildList", page);
        return "listAllCustomer";
    }

    @RequestMapping("aa")
    public String aa (RedirectAttributes attributes, CustomerQo qo){
        if(qo.getPage() < 1) qo.setPage(1);
        attributes.addAttribute("page", qo.getPage());
        attributes.addAttribute("rows", qo.getRows());
        return "redirect:/customer/toListAllCustomer";
    }


    @RequestMapping("listAllCustomer")
    public Object listAllCustomer(CustomerQo qo){
        //List<CustomerChild> customerChildList = customerChildService.listAllCustomer();
        PageInfo page = (PageInfo) customerChildService.listByPage(qo);
        return page;
    }
}
