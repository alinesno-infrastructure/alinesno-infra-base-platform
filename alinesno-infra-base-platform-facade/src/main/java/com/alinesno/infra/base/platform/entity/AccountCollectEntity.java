package com.alinesno.infra.base.platform.entity;

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
public class AccountCollectEntity extends InfraBaseEntity {

	/**
	 * 服务名称
	 */
	@TableField("name")
	private String name;

	/**
	 * 排序
	 */
	@TableField("sort_number")
	private Integer sortNumber;

	/**
	 * 产品ID
	 */
	@TableField("product_id")
	private String productId;

	/**
	 * 账户ID
	 */
	@TableField("account_id")
	private String accountId;


	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSortNumber() {
		return sortNumber;
	}

	public void setSortNumber(Integer sortNumber) {
		this.sortNumber = sortNumber;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "AccountCollectDto [name=" + name + ", sortNumber=" + sortNumber + ", productId=" + productId + "]";
	}

}
