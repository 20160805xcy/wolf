package com.xcy.wolf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xcy
 * @date 2019/02/21 14:20
 * @description LayUI有关
 * @since V1.0.0
 */
@Controller
@RequestMapping("layUI")
public class LayerUIController {

    @RequestMapping("toLayUI")
    public String toLayUI(){
        return "layui";
    }

    @RequestMapping("goLayUI")
    public String goLayUI(){
        return "redirect:/layUI/toLayUI";
    }



}
