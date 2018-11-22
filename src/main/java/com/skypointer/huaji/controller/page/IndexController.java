package com.skypointer.huaji.controller.page;

import com.skypointer.huaji.bean.User;
import com.skypointer.huaji.controller.BaseContrller;
import com.skypointer.huaji.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController extends BaseContrller {
    @Autowired
    private IUserService userService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value={"/index"})
    public String index(){
        //List<User> users = userService.findAll();
        //logger.debug(users.toString());
        return "index";
    }

    @RequestMapping(value={"/"})
    public String login(){
        //List<User> users = userService.findAll();
        //logger.debug(users.toString());
        return "login";
    }
}
