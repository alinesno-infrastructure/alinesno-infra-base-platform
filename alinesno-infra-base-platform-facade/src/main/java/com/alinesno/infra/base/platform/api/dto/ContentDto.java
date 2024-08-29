package com.alinesno.infra.base.platform.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 内容数据传输对象
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ContentDto extends BaseDto {

    private String category; // 内容类型
    private String title; // 标题
    private String titleIcon ; // 标题图标
    private String contentDesc;  // 内容描述
    private String banner;  // 背景图片
    private String bannerDesc; // 图片描述
    private int viewCount ; // 查看次数
}
