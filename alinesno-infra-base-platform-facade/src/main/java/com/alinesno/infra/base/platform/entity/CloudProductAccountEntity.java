package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 这是一个用于存储云产品账户信息的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("cloud_product_account")
public class CloudProductAccountEntity extends InfraBaseEntity {

	/**
	 * 账户id
	 */
	@TableField("account_id")
	private String accountId;

	/**
	 * 产品id
	 */
	@TableField("product_item_id")
	private String productItemId;

	/**
	 * 排序
	 */
	@TableField("sort_number")
	private Integer sortNumber;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getProductItemId() {
		return productItemId;
	}

	public void setProductItemId(String productItemId) {
		this.productItemId = productItemId;
	}

	public Integer getSortNumber() {
		return sortNumber;
	}

	public void setSortNumber(Integer sortNumber) {
		this.sortNumber = sortNumber;
	}

	@Override
	public String toString() {
		return "CloudProductAccountEntity{" +
				"accountId='" + accountId + '\'' +
				", productItemId='" + productItemId + '\'' +
				", sortNumber=" + sortNumber +
				'}';
	}
}
