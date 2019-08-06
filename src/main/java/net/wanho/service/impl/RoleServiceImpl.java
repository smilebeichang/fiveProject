package net.wanho.service.impl;

import net.wanho.mapper.RoleMapper;
import net.wanho.pojo.Role;
import net.wanho.service.RoleServiceI;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/8/3.
 */
@Service
public class RoleServiceImpl implements RoleServiceI {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void insertRole(Role role) {
        roleMapper.insertRole(role);
        //ids字符串，变成Long[]
        String[] arr = role.getIds().split(",");
        Long[] longs = new Long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            longs[i] = Long.parseLong(arr[i]);
        }
        role.setPowerIds(longs);
        roleMapper.insertRolePower(role.getRid(),role.getPowerIds());
    }

    @Override
    public void deleteRole(Integer rid) {
        roleMapper.deleteRole(rid);
        roleMapper.deleteRolePower(rid);
    }

    @Override
    public void updateRole(Role role){
        roleMapper.updateRole(role);
        roleMapper.deleteRolePower(role.getRid());

        //ids字符串，变成Long[]
        String[] arr = role.getIds().split(",");
        Long[] longs = new Long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            longs[i] = Long.parseLong(arr[i]);
        }
        role.setPowerIds(longs);
        roleMapper.insertRolePower(role.getRid(),role.getPowerIds());
    }
}
