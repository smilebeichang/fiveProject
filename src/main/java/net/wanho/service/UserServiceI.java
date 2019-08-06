package net.wanho.service;

import com.github.pagehelper.PageInfo;
import net.wanho.pojo.Power;
import net.wanho.pojo.Role;
import net.wanho.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/8/1.
 */
@Service
public interface UserServiceI {

    PageInfo<User> findAllUserByPage(Integer pageNum);

    User queryUserById(Integer uid);

    void insertUser(User user);

    User getUserByName(String userName);

    void delete(Integer uid);

    List<Role> queryRole(Integer uid);

    void updateUserRole(User user);

    List<Role> queryAllRole();

    Role queryRoleById(Integer rid);

    List<Power> queryAllPower();

    List<Power> queryAllPowerByRid(Integer rid);

    List<Power> queryAllPowerByUid(Integer uid);
}
