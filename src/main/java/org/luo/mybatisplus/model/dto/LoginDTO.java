package org.luo.mybatisplus.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@ApiModel
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LoginDTO {

    @ApiModelProperty(notes = "主键")
    private Integer id;

    @ApiModelProperty(notes = "用户名")
    private String username;

    @ApiModelProperty(notes = "账号")
    private String account;

    @ApiModelProperty(notes = "角色")
    private String role;

    @ApiModelProperty(notes = "创建时间")
    private Date ctime;

}
