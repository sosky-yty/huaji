package com.skypointer.huaji.controller.page;

import com.skypointer.huaji.controller.BaseContrller;
import com.skypointer.huaji.mytool.GeetestLib;
import com.skypointer.huaji.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录页面控制器
 */
@Controller
public class LoginController extends BaseContrller {
    @Autowired
    private IUserService userService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/login"} )
    public String login(){
        return "login";
    }

    @RequestMapping(value = {"/login"} ,method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody Map map){
        String username = (String) map.get("userName");
        String userpwd  = (String) map.get("userPwd");
        String challenge = (String) map.get("challenge");
        String validate = (String) map.get("validate");
        String seccode = (String) map.get("seccode");

        GeetestLib gtsdk = new GeetestLib(GeetestLib.id,GeetestLib.key,GeetestLib.newfailback);
        int gt_server_status_code = (Integer) request.getSession().getAttribute(gtsdk.gtServerStatusSessionKey);
        HashMap<String, String> param = new HashMap<String, String>();

        param.put("user_id", username); //网站用户id
        param.put("client_type", "web"); //web:电脑上的浏览器；h5:手机上的浏览器，包括移动应用内完全内置的web_view；native：通过原生SDK植入APP应用的方式
        param.put("ip_address", "127.0.0.1"); //传输用户请求验证时所携带的IP

        int gtResult = 0;
        if (gt_server_status_code == 1) {
            //gt-server正常，向gt-server进行二次验证
            gtResult = gtsdk.enhencedValidateRequest(challenge, validate, seccode, param);
            System.out.println(gtResult);
        } else {
            // gt-server非正常情况下，进行failback模式验证
            System.out.println("failback:use your own server captcha validate");
            gtResult = gtsdk.failbackValidateRequest(challenge, validate, seccode);
            System.out.println(gtResult);
        }

        if (gtResult == 1){
            //验证成功
            try {
                Subject subject = SecurityUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(username, userpwd);
                subject.login(token);
            }catch(AuthenticationException e){
                logger.debug(e.toString());
            }
            return "1";
        }else {
            //验证失败
            return "0";
        }
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
