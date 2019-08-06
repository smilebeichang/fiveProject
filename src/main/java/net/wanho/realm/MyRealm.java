package net.wanho.realm;

import net.wanho.pojo.User;
import net.wanho.service.UserServiceI;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class MyRealm extends AuthorizingRealm {


    @Autowired
    private UserServiceI userServiceI;


//    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

// 给当前对象赋予角色和权限

        /*List<String> roles= Arrays.asList("admin","staff");
        List<String> permissions = Arrays.asList("user:select","user:add","user:delete","user:update");

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roles);
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;*/
        return null;
    }


//    认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //        自定义认证
//        获取账号
        String username = (String) token.getPrincipal();

        User user = userServiceI.getUserByName(username);
        if (user == null) {
            throw new UnknownAccountException("账号有误");
        }

//        取出用户的密码，按照同样的加密方式进行比对
        return new SimpleAuthenticationInfo(username,user.getPassword(), ByteSource.Util.bytes(user.getSalt()),getName());
    }
}
