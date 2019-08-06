package net.wanho.mapper;

import net.wanho.pojo.Power;
import net.wanho.vo.PowerInfoDto;

import java.util.List;

/**
 * Created by Administrator on 2019/8/3.
 */
public interface PowerMapper {


    /**
     * 查询菜单权限列表
     *
     * @param power 菜单权限信息
     * @return 菜单权限集合
     */
     List<Power> selectPowerList(Power power);

     List<PowerInfoDto> getPowerInfos(Integer rid);
}
