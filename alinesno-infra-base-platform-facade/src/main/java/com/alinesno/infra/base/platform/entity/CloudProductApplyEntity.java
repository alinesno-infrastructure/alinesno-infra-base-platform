package com.alinesno.infra.base.platform.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 这是一个用于存储云产品申请信息的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("cloud_product_apply")
@Data
public class CloudProductApplyEntity extends InfraBaseEntity {

	/**
	 * 用户名
	 */
	@TableField("account_name")
	@ColumnType(length=255)
	@ColumnComment("用户名")
	private String accountName;

	/**
	 * 账户id
	 */
	@TableField("account_id")
	@ColumnType(length=255)
	@ColumnComment("账户id")
	private String accountId;

	/**
	 * 产品id
	 */
	@TableField("product_item_id")
	@ColumnType(length=255)
	@ColumnComment("产品id")
	private String productItemId;

	/**
	 * 申请状态(0未审核|1已审核|2不通过|3通过)
	 */
	@TableField("apply_status")
	@ColumnType(length=255)
	@ColumnComment("申请状态(0未审核|1已审核|2不通过|3通过)")
	private Integer applyStatus;

	/**
	 * 申请原因
	 */
	@TableField("apply_reason")
	@ColumnType(length=255)
	@ColumnComment("申请原因")
	private String applyReason;
}
