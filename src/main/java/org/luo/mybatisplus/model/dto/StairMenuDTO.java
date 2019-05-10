package org.luo.mybatisplus.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@ApiModel("一级菜单许可返回对象")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StairMenuDTO extends ApiDTO {

    @ApiModelProperty("二级菜单")
    private List<SecondaryMenuDTO> secondaryMenus;
}
