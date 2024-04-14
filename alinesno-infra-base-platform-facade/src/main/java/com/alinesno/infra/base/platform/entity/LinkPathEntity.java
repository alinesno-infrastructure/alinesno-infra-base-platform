package com.alinesno.infra.base.platform.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

/**
 * 这是一个用于存储云链接路径的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("link_path")
@Data
public class LinkPathEntity extends InfraBaseEntity {

	/**
	 * 链接类型
	 */
	@TableField("link_type")
	@ColumnType(length=10)
	@ColumnComment("链接类型")
	private String linkType;

	/**
	 * 链接名称
	 */
	@TableField("link_name")
	@ColumnType(length=255)
	@ColumnComment("链接名称")
	private String linkName;

	/**
	 * 链接地址
	 */
	@TableField("link_path")
	@ColumnType(length=255)
	@ColumnComment("链接地址")
	private String linkPath;

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
	@TableField("link_target")
	@ColumnType(length=255)
	@ColumnComment("链接打开状态")
	private String linkTarget;

	/**
	 * 链接状态
	 */
	@TableField("link_design")
	@ColumnType(length=255)
	@ColumnComment("链接状态")
	private String linkDesign;

	/**
	 * 链接排序
	 */
	@TableField("link_sort")
	@ColumnType(length=255)
	@ColumnComment("链接排序")
	private Integer linkSort;
}
