package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 账户产品项实体类
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("account_product_item")
public class AccountProductItemEntity extends InfraBaseEntity {

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
	 * 服务简介
	 */
	@TableField("product_brief")
	private String productBrief;

	/**
	 * 服务描述
	 */
	@TableField("product_describe")
	private String productDescribe;

	/**
	 * 副标题
	 */
	@TableField("sub_name")
	private String subName;

	/**
	 * 背景图
	 */
	@TableField("banner")
	private String banner;

	/**
	 * 简称
	 */
	@TableField("short_name")
	private String shortName;

	/**
	 * 查看次数
	 */
	@TableField("view_count")
	private Integer viewCount;

	/**
	 * 服务链接
	 */
	@TableField("link_path")
	private String linkPath;

	/**
	 * 服务状态
	 * (正常normal|内测internal|公测public)
	 */
	@TableField("prod_status")
	private String prodStatus;

	/**
	 * 是否内置链接
	 * (内置1|正常0)
	 */
	@TableField("has_inner")
	private int hasInner;

	/**
	 * 标识状态
	 * (0启用|1禁用)
	 */
	@TableField("identity_status")
	private String identityStatus;

	/**
	 * 所属类型id
	 */
	@TableField("product_type_id")
	private String productTypeId;

	/**
	 * 所属类型id
	 */
	@TableField("link_open_type")
	private String linkOpenType;

	public int getHasInner() {
		return hasInner;
	}

	public void setHasInner(int hasInner) {
		this.hasInner = hasInner;
	}

	public String getLinkOpenType() {
		return linkOpenType;
	}

	public void setLinkOpenType(String linkOpenType) {
		this.linkOpenType = linkOpenType;
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

	public String getProductBrief() {
		return productBrief;
	}

	public void setProductBrief(String productBrief) {
		this.productBrief = productBrief;
	}

	public String getProductDescribe() {
		return productDescribe;
	}

	public void setProductDescribe(String productDescribe) {
		this.productDescribe = productDescribe;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public String getLinkPath() {
		return linkPath;
	}

	public void setLinkPath(String linkPath) {
		this.linkPath = linkPath;
	}

	public String getProdStatus() {
		return prodStatus;
	}

	public void setProdStatus(String prodStatus) {
		this.prodStatus = prodStatus;
	}

	public String getIdentityStatus() {
		return identityStatus;
	}

	public void setIdentityStatus(String identityStatus) {
		this.identityStatus = identityStatus;
	}

	public String getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}

	@Override
	public String toString() {
		return "AccountProductItemEntity{" +
				"name='" + name + '\'' +
				", sortNumber=" + sortNumber +
				", productBrief='" + productBrief + '\'' +
				", productDescribe='" + productDescribe + '\'' +
				", subName='" + subName + '\'' +
				", banner='" + banner + '\'' +
				", shortName='" + shortName + '\'' +
				", viewCount=" + viewCount +
				", linkPath='" + linkPath + '\'' +
				", prodStatus='" + prodStatus + '\'' +
				", identityStatus='" + identityStatus + '\'' +
				", productTypeId='" + productTypeId + '\'' +
				'}';
	}
}
