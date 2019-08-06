package net.wanho.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Administrator on 2019/8/5.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PowerInfoDto {
    private Integer id;
    private String name;
    private String url;
    private Integer pid;
    private String checked;
    /*children不知道是什么类型的*/
    private List<PowerInfoDto> children;

}
