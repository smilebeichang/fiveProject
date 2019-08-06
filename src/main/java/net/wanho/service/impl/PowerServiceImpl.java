package net.wanho.service.impl;

import net.wanho.exception.DaoException;
import net.wanho.exception.ServiceException;
import net.wanho.mapper.PowerMapper;
import net.wanho.mapper.RolePowerMapper;
import net.wanho.pojo.Power;
import net.wanho.pojo.Role;
import net.wanho.pojo.RolePower;
import net.wanho.service.PowerServiceI;
import net.wanho.vo.PowerInfoDto;
import net.wanho.vo.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/8/3.
 */
@Service
public class PowerServiceImpl implements PowerServiceI {
    @Autowired
    private RolePowerMapper rolePowerMapper;
    @Autowired
    private PowerMapper powerMapper;

    /**
	 * 根据角色id，查询已有的角色菜单List<RoleMenu> selMenu
	 * 所有菜单集合
	 * 要转成的树的数据集合(if如果有菜单，设置选中tree.setChecked(true))
	 */
    public List<Tree> selectPowerList(List<Power>  powers, Integer rid) {
        try {
            //根据角色id，查询已有的角色权限的集合
            List<RolePower> selMenu = null;
            if(rid!=null){
                RolePower rolePower = new RolePower();
                rolePower.setRid(rid);
                selMenu = rolePowerMapper.selectRolePowerList(rolePower);
            }


            //要转成的树的数据集合set,add
            List<Tree> trees = new ArrayList<Tree>();
            for(Power item:powers){
                Tree tree = new Tree();
                tree.setPid(item.getPid());
                tree.setPname(item.getPname());
                tree.setParentId(item.getParentId());
                //如果有菜单，设置选中
                if(selMenu!=null){
                    for(RolePower roleMenu :selMenu){
                        if(item.getPid()==roleMenu.getPid()){
                            tree.setChecked(true);
                        }
                    }
                }
                trees.add(tree);
            }
            return trees;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public List<PowerInfoDto> getPowerInfos(Integer rid) {
        List<PowerInfoDto> powerInfos = powerMapper.getPowerInfos(rid);
        return powerInfos;
    }
}
