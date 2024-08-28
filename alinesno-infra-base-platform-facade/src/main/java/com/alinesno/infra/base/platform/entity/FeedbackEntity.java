package com.alinesno.infra.base.platform.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

/**
 * 这是一个用于存储云反馈的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("feedback")
@Data
public class FeedbackEntity extends InfraBaseEntity {

	/**
	 * 建议类型
	 */
	@Excel(name = "建议类型")
	@TableField("type_code")
	@ColumnType(length=10)
	@ColumnComment("建议类型")
	private String typeCode;

	/**
	 * 评分
	 */
	@Excel(name = "评分")
	@TableField("grade")
	@ColumnType(length=10)
	@ColumnComment("评分")
	private long grade ;

	/**
	 * 标题
	 */
	@Excel(name = "标题")
	@TableField("title")
	@ColumnType(length=255)
	@ColumnComment("标题")
	private String title;

	/**
	 * 问题描述
	 */
	@Excel(name = "建议内容")
	@TableField("problem_desc")
	@ColumnType(length=255)
	@ColumnComment("建议内容")
	private String problemDesc;

	/**
	 * 建议方案
	 */
	@Excel(name = "建议方案")
	@TableField("proposed_solution")
	@ColumnType(length=255)
	@ColumnComment("建议方案")
	private String proposedSolution;

	/**
	 * 关联产品
	 */
	@Excel(name = "关联产品")
	@TableField("product_item_id")
	@ColumnType(length=50)
	@ColumnComment("关联产品")
	private String productItemId;

	/**
	 * 账户名
	 */
	@Excel(name = "账户名")
	@TableField("account_id")
	@ColumnType(length=10)
	@ColumnComment("账户名")
	private long accountId;
}
