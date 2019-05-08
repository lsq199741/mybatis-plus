package org.luo.mybatisplus.model.param;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("管理员重置密码参数")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AdminResetPasswordParam {


    @ApiModelProperty("管理员编号")
    @NotNull(message = "管理员编号不能为空")
    private Integer id;

    @ApiModelProperty("管理员密码盐值")
    @NotBlank(message = "管理员密码盐值不能为空")
    private String salt;
}
