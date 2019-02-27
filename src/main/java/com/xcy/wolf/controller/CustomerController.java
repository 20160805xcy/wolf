package com.xcy.wolf.controller;

import com.github.pagehelper.PageInfo;
import com.xcy.wolf.model.CustomerChild;
import com.xcy.wolf.qo.CustomerQo;
import com.xcy.wolf.service.CustomerChildService;
import com.xcy.wolf.wrapper.BackResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

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
    public HttpSession session;

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

    /**
     * 跳转到登录页logIn.jsp
     * @return
     */
    @RequestMapping("toLogIn")
    public String toLogIn() {
        return "logIn";
    }

    /**
     * 用户登录
     * @param loginName
     * @param passWord
     * @return 登录成功则重定向到用户列表页, 否则重定向到登录页
     */
    @RequestMapping("logIn")
    public String logIn(String loginName, String passWord) {
        CustomerChild customerChild = customerChildService.selectByLogInNameAndPassWord(loginName, passWord);
        if (null != customerChild) {
            session.setAttribute("customerId", customerChild.getId());
            session.setAttribute("customerName", customerChild.getCustomerName());
            session.setAttribute("loginName", customerChild.getLoginName());
            session.setAttribute("role", customerChild.getRole());
            return "redirect:/customer/toListAllCustomer";
        } else {
            return "redirect:/customer/toLogIn";
        }
    }

    /**
     * 方式一:JSP页面传数据方式
     * 查询所有的客户并封装到Model内,并跳转到列表页listAllCustomer.jsp
     * @param model
     * @param qo
     * @return
     */
    @RequestMapping("toListAllCustomer")
    public String toListAllCustomer(Model model, CustomerQo qo) {
        //List<CustomerChild> customerChildList = customerChildService.listAllCustomer();
        PageInfo page = (PageInfo) customerChildService.listByPage(qo);
        model.addAttribute("total", page.getTotal());
        model.addAttribute("pages", page.getPages());
        model.addAttribute("pageNum", page.getPageNum());
        model.addAttribute("customerChildList", page);
        return "listAllCustomer";
    }

    /**
     * 方式二:Json数据实现前后端数据交换
     * 查询所有用户直接返回对象(符合layerUI表格的对象)
     * @param qo
     * @return 如下格式的json数据
     * {
     * "code":0,
     * "msg":"",
     * "count":1000,
     * "data":[
     * {
     * "id":10000,
     * "username":"user-0",
     * "sex":"女",
     * "city":"城市-0",
     * "sign":"签名-0",
     * "experience":255,
     * "wealth":82830700,
     * "classify":"作家",
     * "score":95
     * }
     * ]
     * }
     */
    @RequestMapping("listAllUser")
    @ResponseBody
    public Object listAllUser(CustomerQo qo) {

        /**
         PageInfo page = (PageInfo) customerChildService.listByPage(qo);
         BackResult backResult = new BackResult();
         backResult.setCode(0);
         backResult.setMsg("success");
         backResult.setCount(Integer.parseInt(String.valueOf(page.getTotal())));
         backResult.setData(page.getList());
         return backResult;
         将上面这段代码重构,如下形式.一行代码完成,将重复啰嗦部分提取到BackResult公用.
         **/
        return BackResult.successBack(customerChildService.listByPage(qo));
    }


    /**
     * 分页查询
     * @param attributes
     * @param qo
     * @return
     */
    @RequestMapping("aa")
    public String aa(RedirectAttributes attributes, CustomerQo qo) {
        if (qo.getPage() < 1) qo.setPage(1);
        attributes.addAttribute("page", qo.getPage());
        attributes.addAttribute("rows", qo.getLimit());
        return "redirect:/customer/toListAllCustomer";
    }

    /**
     * 查询详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}/detail", method = RequestMethod.GET)
    public String toListAllCustomer(@PathVariable("id") Integer id, Model model) {
        CustomerChild customerChild = customerChildService.selectById(id);
        model.addAttribute("customerChild", customerChild);
        return "detail";
    }


    /**
     * 查询所有客户
     * @param qo
     * @return
     */
    @RequestMapping("listAllCustomer")
    public Object listAllCustomer(CustomerQo qo) {
        //List<CustomerChild> customerChildList = customerChildService.listAllCustomer();
        PageInfo page = (PageInfo) customerChildService.listByPage(qo);
        return page;
    }
}
