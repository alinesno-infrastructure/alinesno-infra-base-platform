package com.alinesno.infra.base.platform.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

/**
 * 解决方案类型实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("solution_type")
@Data
public class SolutionTypeEntity extends InfraBaseEntity {

	/**
	 * 名称
	 */
	@TableField("name")
	@ColumnType(length=255)
	@ColumnComment("名称")
	private String name;

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
}
