package org.luo.mybatisplus.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.luo.mybatisplus.framework.model.convert.Convert;

@ApiModel("接口许可返回对象")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ApiDTO {

    @ApiModelProperty("许可ID")
    private Integer id;

    @ApiModelProperty("许可说明")
    private String name;

    @ApiModelProperty("许可名称")
    private String permission;

    @ApiModelProperty("许可url")
    private String url;

    @ApiModelProperty("是否启用")
    private String isenable;
}
