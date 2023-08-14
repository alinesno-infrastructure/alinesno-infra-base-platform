package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 云账户审核实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("cloud_account_audit")
public class CloudAccountAuditEntity extends InfraBaseEntity {

	/**
	 * 账户ID
	 */
	@TableField("account_id")
	private String accountId;

	/**
	 * 标题
	 */
	@TableField("title")
	private String title;

	/**
	 * 交易类型
	 */
	@TableField("business_type")
	private String businessType;

	/**
	 * 方法
	 */
	@TableField("method")
	private String method;

	/**
	 * 请求方法
	 */
	@TableField("request_method")
	private String requestMethod;

	/**
	 * 操作类型
	 */
	@TableField("operator_type")
	private String operatorType;

	/**
	 * 操作员
	 */
	@TableField("oper_name")
	private String operName;

	/**
	 * 操作路径
	 */
	@TableField("oper_url")
	private String operUrl;

	/**
	 * 操作IP
	 */
	@TableField("oper_ip")
	private String operIp;

	/**
	 * 操作地址
	 */
	@TableField("oper_location")
	private String operLocation;

	/**
	 * 操作参数
	 */
	@TableField("oper_param")
	private String operParam;

	/**
	 * 错误信息
	 */
	@TableField("error_message")
	private String errorMessage;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(String operatorType) {
		this.operatorType = operatorType;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public String getOperUrl() {
		return operUrl;
	}

	public void setOperUrl(String operUrl) {
		this.operUrl = operUrl;
	}

	public String getOperIp() {
		return operIp;
	}

	public void setOperIp(String operIp) {
		this.operIp = operIp;
	}

	public String getOperLocation() {
		return operLocation;
	}

	public void setOperLocation(String operLocation) {
		this.operLocation = operLocation;
	}

	public String getOperParam() {
		return operParam;
	}

	public void setOperParam(String operParam) {
		this.operParam = operParam;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "CloudAccountAuditEntity{" +
				"accountId='" + accountId + '\'' +
				", title='" + title + '\'' +
				", businessType='" + businessType + '\'' +
				", method='" + method + '\'' +
				", requestMethod='" + requestMethod + '\'' +
				", operatorType='" + operatorType + '\'' +
				", operName='" + operName + '\'' +
				", operUrl='" + operUrl + '\'' +
				", operIp='" + operIp + '\'' +
				", operLocation='" + operLocation + '\'' +
				", operParam='" + operParam + '\'' +
				", errorMessage='" + errorMessage + '\'' +
				'}';
	}
}
