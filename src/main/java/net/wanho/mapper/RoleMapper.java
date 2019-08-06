package net.wanho.mapper;

import net.wanho.pojo.Role;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2019/8/3.
 */
public interface RoleMapper {
    void insertRole(Role role);

    void deleteRole(Integer rid);

    void insertRolePower(@Param("rid") Integer rid, @Param("pids") Long[] powerIds);


    void deleteRolePower(Integer rid);

    void updateRole(Role role);
}
