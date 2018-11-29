package com.skypointer.huaji.controller.page;

import com.skypointer.huaji.controller.BaseContrller;
import com.skypointer.huaji.mytool.GeetestLib;
import com.skypointer.huaji.service.IUserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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

    /**
     * 初始化验证码服务
     * @return
     */
    @RequestMapping(value = "/geetestInit",method = RequestMethod.GET)
    @ResponseBody
    public String geetestInit(){
        GeetestLib gtsdk = new GeetestLib(GeetestLib.id,GeetestLib.key,GeetestLib.newfailback);

        String resstr = "{}";
        //自定义参数,可选择添加
        HashMap<String, String> param = new HashMap<String, String>();

        //进行验证预处理
        int gtServerStatus = gtsdk.preProcess(param);

        //将服务器状态设置到session中
        request.getSession().setAttribute(gtsdk.gtServerStatusSessionKey, gtServerStatus);

        resstr = gtsdk.getResponseStr();
        System.out.println(resstr);
        return resstr;
    }
}
