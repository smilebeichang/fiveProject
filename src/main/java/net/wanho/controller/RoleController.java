package net.wanho.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import net.wanho.pojo.Power;
import net.wanho.pojo.Role;
import net.wanho.service.PowerServiceI;
import net.wanho.service.RoleServiceI;
import net.wanho.service.UserServiceI;
import net.wanho.vo.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/8/2.
 */
@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private UserServiceI userServiceI;
    @Autowired
    private PowerServiceI powerServiceI;
    @Autowired
    private RoleServiceI roleServiceI;

    /**
     * 查询所有角色
     * @param map
     * @return
     */
    @RequestMapping("roleList")
    public String  queryAllRole(Map map){
        List<Role> roles = userServiceI.queryAllRole();
        map.put("roles",roles);
        return "role";
    }

    /**
     * 查询所有权限，并装换成json格式，zTree输出
     * @param map
     * @return
     */
    @RequestMapping("toInsertRole")
    public String toInsert(Map map){
        List<Power> powers = userServiceI.queryAllPower();
        //fastjson  List转JSONArray
        JSONArray array= JSONArray.parseArray(JSON.toJSONString(powers));
        map.put("array",array);
        return "insertRole";
    }

    /**
     * insertRole和insertRolePower（ids字符串，变成Long[]）
     * @param role
     * @return
     */
    @RequestMapping(value = "insertRole",method = RequestMethod.POST)
    public String insert(Role role){
        roleServiceI.insertRole(role);
        return "redirect:roleList";
    }

    /**
     *根据rid查询role,查询所有power,powerList 转 TreeList,TreeList转JSONArray
     * @param map
     * @param rid
     * @return
     */
    @RequestMapping("toUpdate")
    public String  toUpdate(Map map,Integer rid){
        Role role = userServiceI.queryRoleById(rid);
        List<Power> power2 = userServiceI.queryAllPower();
        //powerList 转 TreeList（在Service层写）
        List<Tree> powers3 = powerServiceI.selectPowerList(power2,rid);
        System.err.println("findTree(MenuList 转 TreeList)方法成功执行");
        //fastjson  List转JSONArray
        JSONArray array3= JSONArray.parseArray(JSON.toJSONString(powers3));

        map.put("role",role);
        map.put("array3",array3);
        return "roleUpdate";
    }

    /**
     * 更新角色，删除关联表，新增关联表
     * @param role
     * @return
     */
    @RequestMapping("roleUpdate")
    public String updateRole(Role role){
        roleServiceI.updateRole(role);
        return "redirect:roleList";
    }

    /**
     * delete:role状态改为1,role_power删除
     * @param rid
     * @return
     */
    @RequestMapping("delete")
    public String delete(Integer rid){
        roleServiceI.deleteRole(rid);
        return  "redirect:roleList";
    }

}
