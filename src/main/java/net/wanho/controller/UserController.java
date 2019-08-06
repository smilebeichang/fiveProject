package net.wanho.controller;


import com.github.pagehelper.PageInfo;

import net.wanho.pojo.Role;
import net.wanho.pojo.User;
import net.wanho.service.UserServiceI;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/8/1.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceI userServiceI;

    /**
     * 分页查找用户,返回pageInfo
     * @param pageNum
     * @param map
     * @return
     */
    @RequestMapping("findAllUserByPage")
    public String  findAllByPage(@RequestParam(defaultValue = "1")Integer pageNum, Map map){
        PageInfo<User> pageInfo = userServiceI.findAllUserByPage(pageNum);
        map.put("pageInfo",pageInfo);
        return "user";
    }

    /**
     * 分别根据uid查询用户，查询角色(三表查询）
     * @param map
     * @param uid
     * @return
     */
    @RequestMapping("toUpdate")
    public String toUpdate(Map map,Integer uid){
        User user = userServiceI.queryUserById(uid);
        List<Role> roles = userServiceI.queryRole(uid);

        List<String> rids= new ArrayList<String>();
        for (Role role : roles) {
            rids.add(role.getRid().toString());
        }
        /*String roles2 = StringUtils.join(roles, ",");*/
        System.out.println("控制层：  "+rids);
        map.put("user",user);
        map.put("rids",rids);
        return "update";
    }

    /**
     * 删除关联表，批量增加关系表
     * @param user
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(User user){
        userServiceI.updateUserRole(user);
        return "redirect:findAllUserByPage";
    }

    /*@RequestMapping("toInsert")
    public String toInsert(){
        return "insert";
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(User user){
        userServiceI.insertUser(user);
        return "redirect:findAllUserByPage";
    }*/

    /**
     * 逻辑删除，转态改为1
     * @param uid
     * @return
     */
    @RequestMapping("delete")
    public String delete(Integer uid){
        userServiceI.delete(uid);
        return "redirect:findAllUserByPage";
    }

}
