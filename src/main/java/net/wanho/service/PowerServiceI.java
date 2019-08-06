package net.wanho.service;

import net.wanho.pojo.Power;
import net.wanho.pojo.Role;
import net.wanho.vo.PowerInfoDto;
import net.wanho.vo.Tree;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/8/3.
 */
@Service
public interface PowerServiceI  {

    List<Tree> selectPowerList(List<Power>  power, Integer rid);

    List<PowerInfoDto> getPowerInfos(Integer rid);
}
