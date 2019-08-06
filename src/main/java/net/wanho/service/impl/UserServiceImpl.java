package net.wanho.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.wanho.mapper.PowerMapper;
import net.wanho.mapper.UserMapper;
import net.wanho.pojo.Power;
import net.wanho.pojo.Role;
import net.wanho.pojo.User;
import net.wanho.service.UserServiceI;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2019/8/1.
 */
@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> findAllUserByPage(Integer pageNum) {
        PageHelper.startPage(pageNum,5);
        List<User> scores = userMapper.queryAllUser();
        PageInfo<User> pageInfo = new PageInfo<User>(scores);
        return pageInfo;
    }

    @Override
    public User queryUserById(Integer uid) {

        User user = userMapper.queryById(uid);
        System.out.println("service层：  "+user);
        return user;
    }

    @Override
    public List<Role> queryRole(Integer uid) {
        List<Role> roles = userMapper.queryRole(uid);
        return roles;
    }

    @Override
    public void insertUser(User user) {
        if (user == null) {
            throw new RuntimeException("参数不能为空");
        }
        /*转态+盐值+密码*/
        user.setStatus("0");
        String salt = UUID.randomUUID().toString();
        user.setSalt(salt);
        user.setPassword(shiroMD5(user.getPassword(), salt));
        userMapper.insertUser(user);
    }

    public String shiroMD5(String password,String salt){
        //加密方式  特殊名字来源于shiro.xml
        String hashAlgorithmName="MD5";
        //加密次数
        int hashIterations=2;
        //把salt转成ByteSource
        ByteSource saltSource = ByteSource.Util.bytes(salt);

        Object object = new SimpleHash(hashAlgorithmName, password, saltSource, hashIterations);
        return object.toString();


    }

    @Override
    public User getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }

    @Override
    public  void delete(Integer uid){
        userMapper.delete(uid);
    }


    public void updateUserRole(User user){
        userMapper.updateUser(user);
        userMapper.deleteUserRole(user);
       
       if (user.getRid()!=null){
           userMapper.insertUserRoleBatch(user.getRid(),user.getUid());
       }

    }

    @Override
    public List<Role> queryAllRole() {
        List<Role> roles = userMapper.queryAllRole();
        return roles;
    }

    @Override
    public Role queryRoleById(Integer rid) {
        Role role = userMapper.queryRoleById(rid);
        return role;
    }

    @Override
    public List<Power> queryAllPower() {
        List<Power> powers = userMapper.queryAllPower();
        return powers;
    }

    @Override
    public List<Power> queryAllPowerByRid(Integer rid) {
        List<Power> power = userMapper.queryAllPowerByRid(rid);
        return power;
    }

    @Override
    public List<Power> queryAllPowerByUid(Integer uid) {
        List<Power> powers = userMapper.queryAllPowerByUid(uid);
        return powers;
    }


}
