package org.luo.mybatisplus.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.luo.mybatisplus.framework.model.convert.Convert;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("许可修改参数")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PermissionUpdateParam extends Convert {

    @ApiModelProperty("许可ID")
    @NotNull(message = "许可ID不能为空")
    private Integer id;

    @ApiModelProperty("许可描述")
    @NotBlank(message = "许可描述不能为空")
    private String name;

    @ApiModelProperty("许可类型")
    @NotBlank(message = "许可类型不能为空")
    private String type;

    @ApiModelProperty("许可名称")
    @NotBlank(message = "许可名称不能为空")
    private String permission;

    @ApiModelProperty("接口url")
    private String url;


}
