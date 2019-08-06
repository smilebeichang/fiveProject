package net.wanho.mapper;

import net.wanho.pojo.Power;
import net.wanho.pojo.Role;
import net.wanho.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/8/1.
 */
public interface UserMapper {

    List<User> queryAllUser();

    User queryById(@Param("uid") Integer uid);

    void insertUser(User user);

    User getUserByName(String userName);

    void delete(Integer uid);

    List<Role> queryRole(Integer uid);

    void updateUser(User user);

    void updateRole(User user);

    List<Role> queryAllRole();

    Role queryRoleById(Integer rid);

    void deleteUserRole(User user);

    void insertUserRoleBatch(@Param("rids") List<String> rids,@Param("uid") Integer uid);

    List<Power> queryAllPower();

    List<Power> queryAllPowerByRid(Integer rid);



    void deleteUser(String userName);

    List<Power> queryAllPowerByUid(Integer uid);
}
