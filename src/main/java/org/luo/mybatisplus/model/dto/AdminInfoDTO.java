package org.luo.mybatisplus.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@ApiModel("管理员详情")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AdminInfoDTO {

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("创建人编号")
    private Integer createAdmin;

    @ApiModelProperty("创建人昵称")
    private String createAdminNickName;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
}
