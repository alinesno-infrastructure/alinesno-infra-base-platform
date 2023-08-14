package com.alinesno.infra.base.platform.entity;

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
public class CloudProductApplyEntity extends InfraBaseEntity {

	/**
	 * 用户名
	 */
	@TableField("account_name")
	private String accountName;

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
	 * 申请状态(0未审核|1已审核|2不通过|3通过)
	 */
	@TableField("apply_status")
	private Integer applyStatus;

	/**
	 * 申请原因
	 */
	@TableField("apply_reason")
	private String applyReason;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

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

	public Integer getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}

	public String getApplyReason() {
		return applyReason;
	}

	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}

	@Override
	public String toString() {
		return "CloudProductApplyEntity{" +
				"accountName='" + accountName + '\'' +
				", accountId='" + accountId + '\'' +
				", productItemId='" + productItemId + '\'' +
				", applyStatus=" + applyStatus +
				", applyReason='" + applyReason + '\'' +
				'}';
	}
}
