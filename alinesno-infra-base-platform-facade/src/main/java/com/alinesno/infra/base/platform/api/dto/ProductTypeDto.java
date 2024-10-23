package com.alinesno.infra.base.platform.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductTypeDto extends BaseDto {

    private String icon ; // 图标
    private String name; // 名称
    private String code ; // 业务类型编码
    private String typeDescribe; // 产品类型描述
    private int sortNumber; // 排序
    private String banner; // 背景图
    private String remark; // 备注
    private String typeOwner ; // 类型所有者

    private List<ProductItemDto> productItem;  // 产品项

}
