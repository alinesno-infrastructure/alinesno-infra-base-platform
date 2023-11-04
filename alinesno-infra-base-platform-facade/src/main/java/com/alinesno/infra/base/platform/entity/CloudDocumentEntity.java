package com.alinesno.infra.base.platform.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 这是一个用于存储云文档的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("cloud_document")
@Data
public class CloudDocumentEntity extends InfraBaseEntity {

    /**
     * 文档类型
     */
    @Excel(name = "文档类型")
    @TableField("document_type")
	@ColumnType(length=50)
	@ColumnComment("文档类型")
    private String documentType;

    /**
     * 链接名称
     */
    @Excel(name = "链接名称")
    @TableField("link_name")
	@ColumnType(length=255)
	@ColumnComment("链接名称")
    private String linkName;

    /**
     * 链接地址
     */
    @Excel(name = "链接地址")
    @TableField("link_path")
	@ColumnType(length=255)
	@ColumnComment("链接地址")
    private String linkPath;

    /**
     * 链接图标
     */
    @Excel(name = "链接图标")
    @TableField("link_logo")
	@ColumnType(length=255)
	@ColumnComment("链接图标")
    private String linkLogo;

    /**
     * 链接描述
     */
    @TableField("link_desc")
	@ColumnType(length=255)
	@ColumnComment("链接描述")
    private String linkDesc;

    /**
     * 链接打开状态
     */
    @Excel(name = "链接打开状态")
    @TableField("link_target")
	@ColumnType(length=255)
	@ColumnComment("链接打开状态")
    private String linkTarget;

    /**
     * 链接状态
     */
    @Excel(name = "链接状态")
    @TableField("link_design")
	@ColumnType(length=255)
	@ColumnComment("链接状态")
    private String linkDesign;

    /**
     * 链接排序
     */
    @Excel(name = "链接排序")
    @TableField("link_sort")
	@ColumnType(length=2)
	@ColumnComment("链接排序")
    private Integer linkSort;
}
