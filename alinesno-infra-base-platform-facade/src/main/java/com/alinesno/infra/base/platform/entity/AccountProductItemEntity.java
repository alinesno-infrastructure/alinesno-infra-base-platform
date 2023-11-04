package com.alinesno.infra.base.platform.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 账户产品项实体类
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("account_product_item")
@Data
public class AccountProductItemEntity extends InfraBaseEntity {

	/**
	 * 服务名称
	 */
	@TableField("name")
	@ColumnType(length=255)
	@ColumnComment("服务名称")
	private String name;

	/**
	 * 排序
	 */
	@TableField("sort_number")
	@ColumnType(length=255)
	@ColumnComment("排序")
	private Integer sortNumber;

	/**
	 * 服务简介
	 */
	@TableField("product_brief")
	@ColumnType(length=255)
	@ColumnComment("服务简介")
	private String productBrief;

	/**
	 * 服务描述
	 */
	@TableField("product_describe")
	@ColumnType(length=255)
	@ColumnComment("服务描述")
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
	@ColumnType(length=50)
	@ColumnComment("简称")
	private String shortName;

	/**
	 * 查看次数
	 */
	@TableField("view_count")
	@ColumnType(length=10)
	@ColumnComment("查看次数")
	private Integer viewCount;

	/**
	 * 服务链接
	 */
	@TableField("link_path")
	@ColumnType(length=255)
	@ColumnComment("服务链接")
	private String linkPath;

	/**
	 * 服务状态
	 * (正常normal|内测internal|公测public)
	 */
	@TableField("prod_status")
	@ColumnType(length=10)
	@ColumnComment("服务状态")
	private String prodStatus;

	/**
	 * 是否内置链接
	 * (内置1|正常0)
	 */
	@TableField("has_inner")
	@ColumnType(length=1)
	@ColumnComment("是否内置链接")
	private int hasInner;

	/**
	 * 标识状态
	 * (0启用|1禁用)
	 */
	@TableField("identity_status")
	@ColumnType(length=1)
	@ColumnComment("标识状态")
	private String identityStatus;

	/**
	 * 所属类型id
	 */
	@TableField("product_type_id")
	@ColumnType(length=10)
	@ColumnComment("所属类型id")
	private String productTypeId;

	/**
	 * 所属类型id
	 */
	@TableField("link_open_type")
	@ColumnType(length=1)
	@ColumnComment("所属类型id")
	private String linkOpenType;
}
