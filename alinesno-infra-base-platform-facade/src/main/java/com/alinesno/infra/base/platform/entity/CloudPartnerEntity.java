package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 这是一个用于存储云合作伙伴信息的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("cloud_partner")
public class CloudPartnerEntity extends InfraBaseEntity {

	/**
	 * 合作伙伴类型
	 */
	@TableField("partner_type")
	private String partnerType;

	/**
	 * 公司logo
	 */
	@TableField("logo")
	private String logo;

	/**
	 * 公司名称
	 */
	@TableField("company_name")
	private String companyName;

	/**
	 * 联系电话
	 */
	@TableField("company_tel")
	private String companyTel;

	/**
	 * 联系邮箱
	 */
	@TableField("company_email")
	private String companyEmail;

	/**
	 * 公司地址
	 */
	@TableField("company_address")
	private String companyAddress;

	/**
	 * 公司简介
	 */
	@TableField("company_desc")
	private String companyDesc;

	/**
	 * 排序
	 */
	@TableField("sort_number")
	private Integer sortNumber;

	public String getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(String partnerType) {
		this.partnerType = partnerType;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyTel() {
		return companyTel;
	}

	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyDesc() {
		return companyDesc;
	}

	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}

	public Integer getSortNumber() {
		return sortNumber;
	}

	public void setSortNumber(Integer sortNumber) {
		this.sortNumber = sortNumber;
	}

	@Override
	public String toString() {
		return "CloudPartnerEntity{" +
				"partnerType='" + partnerType + '\'' +
				", logo='" + logo + '\'' +
				", companyName='" + companyName + '\'' +
				", companyTel='" + companyTel + '\'' +
				", companyEmail='" + companyEmail + '\'' +
				", companyAddress='" + companyAddress + '\'' +
				", companyDesc='" + companyDesc + '\'' +
				", sortNumber=" + sortNumber +
				'}';
	}
}
