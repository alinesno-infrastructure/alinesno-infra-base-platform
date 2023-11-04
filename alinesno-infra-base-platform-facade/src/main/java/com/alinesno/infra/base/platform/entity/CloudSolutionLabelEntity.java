package com.alinesno.infra.base.platform.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 解决方案标签实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("cloud_solution_label")
@Data
public class CloudSolutionLabelEntity extends InfraBaseEntity {

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
	 * 排序
	 */
	@TableField("sort_number")
	@ColumnType(length=255)
	@ColumnComment("排序")
	private Integer sortNumber;

	/**
	 * 所属解决方案id
	 */
	@TableField("solution_article_id")
	@ColumnType(length=255)
	@ColumnComment("所属解决方案id")
	private String solutionArticleId;
}
