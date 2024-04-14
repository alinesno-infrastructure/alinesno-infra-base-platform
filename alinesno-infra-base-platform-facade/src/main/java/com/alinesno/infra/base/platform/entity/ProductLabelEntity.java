package com.alinesno.infra.base.platform.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

/**
 * 这是一个用于存储云产品标签信息的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("product_label")
@Data
public class ProductLabelEntity extends InfraBaseEntity {

	/**
	 * 标题
	 */
	@TableField("title")
	@ColumnType(length=255)
	@ColumnComment("标题")
	private String title;

	/**
	 * 类型(business业务|advantage优势|case案例)
	 */
	@TableField("label_type")
	@ColumnType(length=255)
	@ColumnComment("类型(business业务|advantage优势|case案例)")
	private String labelType;

	/**
	 * 描述
	 */
	@TableField("label_describe")
	@ColumnType(length=255)
	@ColumnComment("描述")
	private String labelDescribe;

	/**
	 * 背景图
	 */
	@TableField("banner")
	@ColumnType(length=255)
	@ColumnComment("背景图")
	private String banner;

	/**
	 * 排序
	 */
	@TableField("sort_number")
	@ColumnType(length=255)
	@ColumnComment("排序")
	private Integer sortNumber;

	/**
	 * 详情简介
	 */
	@TableField("details_desc")
	@ColumnType(length=255)
	@ColumnComment("详情简介")
	private String detailsDesc;

	/**
	 * 详情标题
	 */
	@TableField("details_title")
	@ColumnType(length=255)
	@ColumnComment("详情标题")
	private String detailsTitle;

	/**
	 * 详情描述
	 */
	@TableField("details_describe")
	@ColumnType(length=255)
	@ColumnComment("详情描述")
	private String detailsDescribe;

	/**
	 * 所属产品id
	 */
	@TableField("product_item_id")
	@ColumnType(length=255)
	@ColumnComment("所属产品id")
	private String productItemId;
}
