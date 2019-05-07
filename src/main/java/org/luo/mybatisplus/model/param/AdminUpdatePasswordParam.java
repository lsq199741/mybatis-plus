package org.luo.mybatisplus.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@ApiModel("管理员修改密码参数")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AdminUpdatePasswordParam {

    @ApiModelProperty("旧密码")
    @NotBlank(message = "旧密码不能为空")
    private String oldPassword;

    @ApiModelProperty("新密码")
    @NotBlank(message = "新密码不能为空")
    private String newPassword;

}
