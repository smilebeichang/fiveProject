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
public class Role {
    private Integer rid;
    private String roleName;
    private Integer status;
    /** 菜单组：权限菜单： */
    private String ids;
    private Long[] powerIds;
    private List<Power> powerList;


}
