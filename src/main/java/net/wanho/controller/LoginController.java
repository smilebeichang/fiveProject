package net.wanho.controller;

import javafx.scene.control.Alert;
import net.wanho.pojo.User;
import net.wanho.service.UserServiceI;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2019/8/1.
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserServiceI userServiceI;

    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }


    @RequestMapping("register")
    public String register(User user){
        String viewName = "false";

        User user2 = userServiceI.getUserByName(user.getUserName());
        if (user2 != null) {
            //throw new UnknownAccountException("账号已存在！");
            return "false";
        }

        try {
            userServiceI.insertUser(user);
            viewName = "redirect:toLogin";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return viewName;
    }

    @RequestMapping("check")
    public String check(User user) {
        String viewName="false";


        if (user == null) {
            throw new RuntimeException("参数不能为空");
        }

        try {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            //userServiceI.queryAllPowerByUid(user.getUid());
            viewName = "redirect:/user/findAllUserByPage";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return viewName;
    }

}
