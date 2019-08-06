package net.wanho.mapper;

import net.wanho.pojo.RolePower;

import java.util.List;

/**
 * Created by Administrator on 2019/8/3.
 */
public interface RolePowerMapper {

    /**
     * 查询角色和菜单关联列表
     *
     * @param rolePower 角色和菜单关联信息
     * @return 角色和菜单关联集合
     */
     List<RolePower> selectRolePowerList(RolePower rolePower);
}
