package com.alinesno.infra.base.platform.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

/**
 * 这是一个用于存储云内容的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("content")
@Data
public class ContentEntity extends InfraBaseEntity {

    /**
     * 内容类型
     */
    @Excel(name = "内容类型")
    @TableField("content_type_value")
	@ColumnType(length=255)
	@ColumnComment("内容类型")
    private String contentTypeValue;

    /**
     * 标题
     */
    @Excel(name = "标题")
    @TableField("title")
	@ColumnType(length=255)
	@ColumnComment("标题")
    private String title;

    /**
     * 内容描述
     */
    @TableField("content_desc")
	@ColumnType(length=255)
	@ColumnComment("内容描述")
    private String contentDesc;

    /**
     * 背景图片
     */
    @TableField("banner")
	@ColumnType(length=255)
	@ColumnComment("背景图片")
    private String banner;

    /**
     * 图片描述
     */
    @TableField("banner_desc")
	@ColumnType(length=255)
	@ColumnComment("图片描述")
    private String bannerDesc;

    /**
     * 查看次数
     */
    @TableField("view_count")
	@ColumnType(length=10)
	@ColumnComment("查看次数")
    private int viewCount ;
}
