package net.wanho.service;

import net.wanho.pojo.Role;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/8/3.
 */
@Service
public interface RoleServiceI {


    void insertRole(Role role);

    void deleteRole(Integer rid);

    void updateRole(Role role);
}
