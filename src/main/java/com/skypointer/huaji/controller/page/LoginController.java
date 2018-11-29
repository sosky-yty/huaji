package com.skypointer.huaji.controller.page;

import com.skypointer.huaji.controller.BaseContrller;
import com.skypointer.huaji.service.IUserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录页面控制器
 */
@Controller
public class LoginController extends BaseContrller {
    @Autowired
    private IUserService userService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
