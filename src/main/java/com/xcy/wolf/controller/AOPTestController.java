package com.xcy.wolf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xcy
 * @date 2019/02/28 11:30
 * @description AOP各种通知测试
 * @since V1.0.0
 */
@RestController
@RequestMapping("AOPTest")
public class AOPTestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("testAdvices")
    public Object testAdvices(String param1, String param2) {
        logger.info("正在执行testAdvices({},{}) 方法", param1, param2);
        return param1 + "-" + param2;
    }
}
