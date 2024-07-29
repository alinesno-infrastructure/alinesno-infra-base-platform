package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 这是一个用于存储产品访问记录的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("product_access_info")
@Data
public class ProductAccessInfoEntity extends InfraBaseEntity {

	/**
	 * 账户id
	 */
	@TableField("account_id")
	@ColumnComment("账户id")
	private Long accountId;

	/**
	 * 账户名称
	 */
	@TableField("account_name")
	@ColumnComment("账户名称")
	private String accountName;

	/**
	 * 产品id
	 */
	@TableField("product_item_id")
	@ColumnType(length=255)
	@ColumnComment("产品id")
	private Long productItemId;

	/**
	 * 产品名称
	 */
	@TableField("product_item_name")
	@ColumnType(length=255)
	@ColumnComment("产品名称")
	private String productItemName;


}
