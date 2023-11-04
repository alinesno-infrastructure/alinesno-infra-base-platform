package com.alinesno.infra.base.platform.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 账户收藏实体类
 * 使用 MyBatis-Plus 注解进行数据库映射
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("account_collect_item")
@Data
public class AccountCollectEntity extends InfraBaseEntity {

	/**
	 * 服务名称
	 */
	@TableField("name")
	@ColumnType(length=255)
	@ColumnComment("服务名称")
	private String name;

	/**
	 * 排序
	 */
	@TableField("sort_number")
	@ColumnType(length=255)
	@ColumnComment("排序")
	private Integer sortNumber;

	/**
	 * 产品ID
	 */
	@TableField("product_id")
	@ColumnType(length=50)
	@ColumnComment("产品ID")
	private String productId;

	/**
	 * 账户ID
	 */
	@TableField("account_id")
	@ColumnType(length=10)
	@ColumnComment("账户ID")
	private String accountId;
}
