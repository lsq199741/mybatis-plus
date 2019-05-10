package org.luo.mybatisplus.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@ApiModel("二级菜单许可返回对象")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SecondaryMenuDTO extends ApiDTO {

    @ApiModelProperty("二级菜单下操作")
    private List<ApiDTO> apis;
}
