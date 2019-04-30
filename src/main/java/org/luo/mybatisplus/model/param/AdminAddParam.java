package org.luo.mybatisplus.model.param;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@ApiModel("管理员添加参数")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AdminAddParam {

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码盐值")
    private String salt;
}
