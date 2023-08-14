package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 服务类型实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("cloud_service_type")
public class CloudServiceTypeEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 名称
	 */
	@TableField("service_type_name")
	private String serviceTypeName;

	/**
	 * 编码
	 */
	@TableField("service_type_number")
	private String serviceTypeNumber;

	/**
	 * 排序
	 */
	@TableField("service_type_seq")
	private Integer serviceTypeSeq;

	/**
	 * 描述
	 */
	@TableField("service_type_desc")
	private String serviceTypeDesc;

	public String getServiceTypeName() {
		return serviceTypeName;
	}

	public void setServiceTypeName(String serviceTypeName) {
		this.serviceTypeName = serviceTypeName;
	}

	public String getServiceTypeNumber() {
		return serviceTypeNumber;
	}

	public void setServiceTypeNumber(String serviceTypeNumber) {
		this.serviceTypeNumber = serviceTypeNumber;
	}

	public Integer getServiceTypeSeq() {
		return serviceTypeSeq;
	}

	public void setServiceTypeSeq(Integer serviceTypeSeq) {
		this.serviceTypeSeq = serviceTypeSeq;
	}

	public String getServiceTypeDesc() {
		return serviceTypeDesc;
	}

	public void setServiceTypeDesc(String serviceTypeDesc) {
		this.serviceTypeDesc = serviceTypeDesc;
	}

	@Override
	public String toString() {
		return "CloudServiceTypeEntity{" +
				"serviceTypeName='" + serviceTypeName + '\'' +
				", serviceTypeNumber='" + serviceTypeNumber + '\'' +
				", serviceTypeSeq=" + serviceTypeSeq +
				", serviceTypeDesc='" + serviceTypeDesc + '\'' +
				'}';
	}
}
