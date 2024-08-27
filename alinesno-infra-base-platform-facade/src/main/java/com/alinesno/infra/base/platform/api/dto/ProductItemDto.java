package com.alinesno.infra.base.platform.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductItemDto extends BaseDto {

    private long orgId ; // 所属组织id

    private String name; // 产品名称
    private String icon; // 产品图标
    private Integer sortNumber;  // 排序
    private String productBrief;  // 产品简介
    private String productDescribe; // 产品描述
    private String subName; // 副标题
    private String banner;  // 背景图
    private String shortName;  // 简称
    private Integer viewCount;  // 查看次数
    private String linkPath; // 产品链接

    // @ColumnComment("产品状态(正常normal|内测internal|公测public)")
    private String prodStatus = "internal";

    // @ColumnComment("是否公开(0不公开|1不公开)")
    private Integer isPublic = 1;

    // @ColumnComment("标识状态(0启用|1禁用)")
    private String identityStatus;

    private String productTypeId;
    private int hasRecommend;

    // @ColumnComment("是否内置链接(内置1|正常0)")
    private int hasInner;
    private String productOwner ;
}
