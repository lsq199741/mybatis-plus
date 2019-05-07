package org.luo.mybatisplus.model.param;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("管理员修改参数")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AdminUpdateParam {

    @ApiModelProperty("管理员编号")
    @NotNull(message = "管理员编号不能为空")
    private Integer id;

    @ApiModelProperty("管理员昵称")
    private String nickname;
//
//    @ApiModelProperty("管理员密码")
//    @NotNull(message = "管理员密码不能为空")
//    private String password;
//
//    @ApiModelProperty("管理员密码盐值")
//    private String salt;
}
