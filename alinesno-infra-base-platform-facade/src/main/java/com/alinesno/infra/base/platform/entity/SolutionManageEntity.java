package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 这是一个用于存储方案管理的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("solution_manage")
@Data
public class SolutionManageEntity extends InfraBaseEntity {

	/**
	 * 方案标题
	 */
	@TableField("title")
	@ColumnComment("方案标题")
	private String title;

	/**
	 * 方案内容
	 */
	@TableField("content")
	@ColumnComment("方案内容")
	private String content;

	/**
	 * 方案链接
	 */
	@TableField("link")
	@ColumnComment("方案链接")
	private String link;

	/**
	 * 方案类型
	 */
	@TableField("solution_type_id")
	@ColumnType(length=255)
	@ColumnComment("方案所属类型")
	private Long solutionTypeId;

	/**
	 * 方案内容
	 */
	@TableField("remark")
	@ColumnComment("备注")
	@ColumnType(length = 2000)
	private String remark;


}
