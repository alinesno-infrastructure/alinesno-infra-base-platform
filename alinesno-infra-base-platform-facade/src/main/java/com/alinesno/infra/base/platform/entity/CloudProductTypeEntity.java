package com.alinesno.infra.base.platform.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 产品类型实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("cloud_product_type")
@Data
public class CloudProductTypeEntity extends InfraBaseEntity {

	/**
	 * 名称
	 */
	@TableField("name")
	@ColumnType(length=255)
	@ColumnComment("名称")
	private String name;

	/**
	 * 排序
	 */
	@TableField("sort_number")
	@ColumnType(length=255)
	@ColumnComment("排序")
	private Integer sortNumber;

	/**
	 * 背景图
	 */
	@TableField("banner")
	@ColumnType(length=255)
	@ColumnComment("背景图")
	private String banner;

	/**
	 * 父类id
	 */
	@TableField("parent_id")
	@ColumnType(length=255)
	@ColumnComment("父类id")
	private String parentId;

	/**
	 * 子名称
	 */
	@TableField("sub_name")
	@ColumnType(length=255)
	@ColumnComment("子名称")
	private String subName;

	/**
	 * 产品类型描述
	 */
	@TableField("type_describe")
	@ColumnType(length=255)
	@ColumnComment("产品类型描述")
	private String typeDescribe;
}
