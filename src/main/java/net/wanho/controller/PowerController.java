package net.wanho.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import net.wanho.pojo.Power;
import net.wanho.pojo.Role;
import net.wanho.service.PowerServiceI;
import net.wanho.service.UserServiceI;
import net.wanho.vo.PowerInfoDto;
import net.wanho.vo.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/8/2.
 */
@Controller
@RequestMapping("power")
/*此注解不知道会不会影响其他方法
@RestController*/
public class PowerController {
    @Autowired
    private UserServiceI userserviceI;
    @Autowired
    private PowerServiceI powerServiceI;

    @RequestMapping("powerList")
    public String powerList(Map map){
        //List<Power> powers = userserviceI.queryAllPower();
        //map.put("powers",powers);
        List<PowerInfoDto> powerInfoDtos = powerServiceI.getPowerInfos(8);
        System.out.println(powerInfoDtos);
        map.put("powerInfoDtos",powerInfoDtos);

        //PowerInfoDto(id=3, name=power, url=user:update, pid=8, checked=null, children=[PowerInfoDto(id=null, name=null, url=null, pid=3, checked=null, children=null), PowerInfoDto(id=null, name=null, url=null, pid=3, checked=null, children=null), PowerInfoDto(id=null, name=null, url=null, pid=3, checked=null, children=null), PowerInfoDto(id=null, name=null, url=null, pid=3, checked=null, children=null)])
        //PowerInfoDto(id=2, name=role, url=user:add, pid=8, checked=null, children=[PowerInfoDto(id=null, name=null, url=null, pid=2, checked=null, children=null), PowerInfoDto(id=null, name=null, url=null, pid=2, checked=null, children=null), PowerInfoDto(id=null, name=null, url=null, pid=2, checked=null, children=null)])
        //PowerInfoDto(id=1, name=user, url=user:select, pid=8, checked=null, children=[PowerInfoDto(id=null, name=null, url=null, pid=1, checked=null, children=null), PowerInfoDto(id=null, name=null, url=null, pid=1, checked=null, children=null), PowerInfoDto(id=null, name=null, url=null, pid=1, checked=null, children=null), PowerInfoDto(id=null, name=null, url=null, pid=1, checked=null, children=null)])

        //[PowerInfoDto(id=8, name=权限, url=user:select, pid=0, checked=null,
        // children=[PowerInfoDto(id=3, name=power, url=user:update, pid=8, checked=null, children=[PowerInfoDto(id=null, name=null, url=null, pid=3, checked=null, children=null), PowerInfoDto(id=null, name=null, url=null, pid=3, checked=null, children=null), PowerInfoDto(id=null, name=null, url=null, pid=3, checked=null, children=null), PowerInfoDto(id=null, name=null, url=null, pid=3, checked=null, children=null)]),
        // PowerInfoDto(id=2, name=role, url=user:add, pid=8, checked=null, children=[PowerInfoDto(id=null, name=null, url=null, pid=2, checked=null, children=null), PowerInfoDto(id=null, name=null, url=null, pid=2, checked=null, children=null), PowerInfoDto(id=null, name=null, url=null, pid=2, checked=null, children=null)]),
        // PowerInfoDto(id=1, name=user, url=user:select, pid=8, checked=null, children=[PowerInfoDto(id=null, name=null, url=null, pid=1, checked=null, children=null), PowerInfoDto(id=null, name=null, url=null, pid=1, checked=null, children=null), PowerInfoDto(id=null, name=null, url=null, pid=1, checked=null, children=null), PowerInfoDto(id=null, name=null, url=null, pid=1, checked=null, children=null)])])]




        //return "powerList2";
        return "powerList4";
    }

    /**
     * findTree获得edit页面的权限菜单，没有这一步就不能执行新增功能，前段请求方式不一样
     * 上级菜单的仅可读的zTree结构
     * to_tree()--->tree.jsp--->findTree()
     * 返回一个List<Tree>，类似于Dept的treeTableList()但多了一步转换为Tree泛型
     */
    /*@RequestMapping("findTree")
    public String  findTree(HttpServletRequest request, HttpServletResponse response,Map map) throws IOException {
        PrintWriter out = response.getWriter();
        Power power = new Power();
        String rid = request.getParameter("rid");
        List<Tree> powers3 = powerServiceI.selectMenuList(power,rid);
        //MenuList 转 TreeList（在Servlice层写）
        System.err.println("findTree(MenuList 转 TreeList)方法成功执行");
        out.println(JSON.toJSON(powers3));
        JSONArray array3= JSONArray.parseArray(JSON.toJSONString(powers3));

        map.put("array3",array3);

        out.flush();
        out.close();
        return "roleUpdate";
    }*/

    /*@RequestMapping(value = "getPowerInfo",method = RequestMethod.POST)

    public Object  getPowerInfo(@RequestBody Role role){
        List<PowerInfoDto> powerInfoDtos = powerServiceI.getPowerInfos();
        System.out.println(powerInfoDtos);
        return powerInfoDtos;
    }*/



}
