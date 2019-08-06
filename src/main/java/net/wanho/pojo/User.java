package net.wanho.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Administrator on 2019/8/1.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer uid;
    private String userName;
    private String password;
    private String status;
    private String salt;
    //增加关系表
    private List<Role> roles;
    private List<String> rid;
}
