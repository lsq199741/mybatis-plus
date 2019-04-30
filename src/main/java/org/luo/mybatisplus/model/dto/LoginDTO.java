package org.luo.mybatisplus.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@ApiModel("管理员登陆")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LoginDTO {

    @ApiModelProperty(notes = "主键")
    private Integer id;

    @ApiModelProperty(notes = "昵称")
    private String nickname;

    @ApiModelProperty(notes = "账号")
    private String username;
}
