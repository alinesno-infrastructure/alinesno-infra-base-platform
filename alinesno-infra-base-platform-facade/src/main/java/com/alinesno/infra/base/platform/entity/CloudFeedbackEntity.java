package com.alinesno.infra.base.platform.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 这是一个用于存储云反馈的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("cloud_feedback")
public class CloudFeedbackEntity extends InfraBaseEntity {

	/**
	 * 建议类型
	 */
	@Excel(name = "建议类型")
	@TableField("type_code")
	private String typeCode;

	/**
	 * 标题
	 */
	@Excel(name = "标题")
	@TableField("title")
	private String title;

	/**
	 * 问题描述
	 */
	@Excel(name = "问题描述")
	@TableField("problem_desc")
	private String problemDesc;

	/**
	 * 建议方案
	 */
	@Excel(name = "建议方案")
	@TableField("proposed_solution")
	private String proposedSolution;

	/**
	 * 关联产品
	 */
	@Excel(name = "关联产品")
	@TableField("product_item_id")
	private String productItemId;

	/**
	 * 账户名
	 */
	@Excel(name = "账户名")
	@TableField("account_id")
	private String accountId;


	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProblemDesc() {
		return problemDesc;
	}

	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}

	public String getProposedSolution() {
		return proposedSolution;
	}

	public void setProposedSolution(String proposedSolution) {
		this.proposedSolution = proposedSolution;
	}

	public String getProductItemId() {
		return productItemId;
	}

	public void setProductItemId(String productItemId) {
		this.productItemId = productItemId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "CloudFeedbackEntity{" +
				"typeCode='" + typeCode + '\'' +
				", title='" + title + '\'' +
				", problemDesc='" + problemDesc + '\'' +
				", proposedSolution='" + proposedSolution + '\'' +
				", productItemId='" + productItemId + '\'' +
				", accountId='" + accountId + '\'' +
				'}';
	}
}
