package com.alinesno.infra.base.platform.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

/**
 * 云账户审核实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("account_audit")
@Data
public class AccountAuditEntity extends InfraBaseEntity {

	/**
	 * 账户ID
	 */
	@TableField("account_id")
	@ColumnType(length=10)
	@ColumnComment("账户ID")
	private String accountId;

	/**
	 * 标题
	 */
	@TableField("title")
	@ColumnType(length=255)
	@ColumnComment("标题")
	private String title;

	/**
	 * 交易类型
	 */
	@TableField("business_type")
	@ColumnType(length=20)
	@ColumnComment("交易类型")
	private String businessType;

	/**
	 * 方法
	 */
	@TableField("method")
	@ColumnType(length=255)
	@ColumnComment("方法")
	private String method;

	/**
	 * 请求方法
	 */
	@TableField("request_method")
	@ColumnType(length=4)
	@ColumnComment("请求方法")
	private String requestMethod;

	/**
	 * 操作类型
	 */
	@TableField("operator_type")
	@ColumnType(length=10)
	@ColumnComment("操作类型")
	private String operatorType;

	/**
	 * 操作员
	 */
	@TableField("oper_name")
	@ColumnType(length=50)
	@ColumnComment("操作员")
	private String operName;

	/**
	 * 操作路径
	 */
	@TableField("oper_url")
	@ColumnType(length=255)
	@ColumnComment("操作路径")
	private String operUrl;

	/**
	 * 操作IP
	 */
	@TableField("oper_ip")
	@ColumnType(length=15)
	@ColumnComment("操作IP")
	private String operIp;

	/**
	 * 操作地址
	 */
	@TableField("oper_location")
	@ColumnType(length=255)
	@ColumnComment("操作地址")
	private String operLocation;

	/**
	 * 操作参数
	 */
	@TableField("oper_param")
	@ColumnType(length=255)
	@ColumnComment("操作参数")
	private String operParam;

	/**
	 * 错误信息
	 */
	@TableField("error_message")
	@ColumnType(length=255)
	@ColumnComment("错误信息")
	private String errorMessage;
}
