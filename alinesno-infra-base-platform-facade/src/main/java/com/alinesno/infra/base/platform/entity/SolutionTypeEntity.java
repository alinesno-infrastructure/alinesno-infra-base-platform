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
	 * 图标
	 */
	@TableField("icon")
	@ColumnType(length=255)
	@ColumnComment("图标")
	private String icon ;

	/**
	 * 名称
	 */
	@TableField("type_name")
	@ColumnType(length=255)
	@ColumnComment("名称")
	private String typeName;

	/**
	 * 描述
	 */
	@TableField("type_describe")
	@ColumnType(length=255)
	@ColumnComment("描述")
	private String typeDescribe;


	/**
	 * 父类id
	 */
	@TableField("parent_id")
	@ColumnComment("父类id")
	private Long parentId;

}
