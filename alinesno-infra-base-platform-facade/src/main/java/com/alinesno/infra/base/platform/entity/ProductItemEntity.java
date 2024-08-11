package com.alinesno.infra.base.platform.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

/**
 * 这是一个用于存储云产品项信息的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("product_item")
@Data
public class ProductItemEntity extends InfraBaseEntity {

	/**
	 * 产品名称
	 */
	@TableField("name")
	@ColumnType(length=255)
	@ColumnComment("产品名称")
	private String name;

	/**
	 * 产品图标
	 */
	@TableField("icon")
	@ColumnType(length=64)
	@ColumnComment("产品图标")
	private String icon;

	/**
	 * 排序
	 */
	@TableField("sort_number")
	@ColumnType(length=255)
	@ColumnComment("排序")
	private Integer sortNumber;

	/**
	 * 产品简介
	 */
	@TableField("product_brief")
	@ColumnType(length=255)
	@ColumnComment("产品简介")
	private String productBrief;

	/**
	 * 产品描述
	 */
	@TableField("product_describe")
	@ColumnType(length=255)
	@ColumnComment("产品描述")
	private String productDescribe;

	/**
	 * 副标题
	 */
	@TableField("sub_name")
	@ColumnType(length=255)
	@ColumnComment("副标题")
	private String subName;

	/**
	 * 背景图
	 */
	@TableField("banner")
	@ColumnType(length=255)
	@ColumnComment("背景图")
	private String banner;

	/**
	 * 简称
	 */
	@TableField("short_name")
	@ColumnType(length=255)
	@ColumnComment("简称")
	private String shortName;

	/**
	 * 查看次数
	 */
	@TableField("view_count")
	@ColumnType(length=255)
	@ColumnComment("查看次数")
	private Integer viewCount;

	/**
	 * 产品链接
	 */
	@TableField("link_path")
	@ColumnType(length=255)
	@ColumnComment("产品链接")
	private String linkPath;

	/**
	 * 产品状态(正常normal|内测internal|公测public)
	 */
	@TableField("prod_status")
	@ColumnType(length=255)
	@ColumnComment("产品状态(正常normal|内测internal|公测public)")
	private String prodStatus = "internal";

	/**
	 * 当前状态(规划planning|研究research|生产production)
	 */
	@TableField("is_public")
	@ColumnType(length=255)
	@ColumnComment("是否公开(0不公开|1不公开)")
	private Integer isPublic = 1;

	/**
	 * 标识状态(0启用|1禁用)
	 */
	@TableField("identity_status")
	@ColumnType(length=255)
	@ColumnComment("标识状态(0启用|1禁用)")
	private String identityStatus;

	/**
	 * 所属类型id
	 */
	@TableField("product_type_id")
	@ColumnType(length=255)
	@ColumnComment("所属类型id")
	private String productTypeId;

	/**
	 * 是否推荐
	 */
	@TableField("has_recommend")
	@ColumnType(length=255)
	@ColumnComment("是否推荐")
	private int hasRecommend;

	/**
	 * 是否内置链接(内置1|正常0)
	 */
	@TableField("has_inner")
	@ColumnType(length=255)
	@ColumnComment("是否内置链接(内置1|正常0)")
	private int hasInner;
}
