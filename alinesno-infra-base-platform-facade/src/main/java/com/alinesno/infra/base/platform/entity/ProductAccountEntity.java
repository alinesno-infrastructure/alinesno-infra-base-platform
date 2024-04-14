package com.alinesno.infra.base.platform.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

/**
 * 这是一个用于存储云产品账户信息的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("product_account")
@Data
public class ProductAccountEntity extends InfraBaseEntity {

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
	 * 排序
	 */
	@TableField("sort_number")
	@ColumnType(length=255)
	@ColumnComment("排序")
	private Integer sortNumber;
}
