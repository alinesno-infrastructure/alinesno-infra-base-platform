package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 这是一个用于存储云产品标签信息的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("cloud_product_label")
public class CloudProductLabelEntity extends InfraBaseEntity {

	/**
	 * 标题
	 */
	@TableField("title")
	private String title;

	/**
	 * 类型(business业务|advantage优势|case案例)
	 */
	@TableField("label_type")
	private String labelType;

	/**
	 * 描述
	 */
	@TableField("label_describe")
	private String labelDescribe;

	/**
	 * 背景图
	 */
	@TableField("banner")
	private String banner;

	/**
	 * 排序
	 */
	@TableField("sort_number")
	private Integer sortNumber;

	/**
	 * 详情简介
	 */
	@TableField("details_desc")
	private String detailsDesc;

	/**
	 * 详情标题
	 */
	@TableField("details_title")
	private String detailsTitle;

	/**
	 * 详情描述
	 */
	@TableField("details_describe")
	private String detailsDescribe;

	/**
	 * 所属产品id
	 */
	@TableField("product_item_id")
	private String productItemId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLabelType() {
		return labelType;
	}

	public void setLabelType(String labelType) {
		this.labelType = labelType;
	}

	public String getLabelDescribe() {
		return labelDescribe;
	}

	public void setLabelDescribe(String labelDescribe) {
		this.labelDescribe = labelDescribe;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public Integer getSortNumber() {
		return sortNumber;
	}

	public void setSortNumber(Integer sortNumber) {
		this.sortNumber = sortNumber;
	}

	public String getDetailsDesc() {
		return detailsDesc;
	}

	public void setDetailsDesc(String detailsDesc) {
		this.detailsDesc = detailsDesc;
	}

	public String getDetailsTitle() {
		return detailsTitle;
	}

	public void setDetailsTitle(String detailsTitle) {
		this.detailsTitle = detailsTitle;
	}

	public String getDetailsDescribe() {
		return detailsDescribe;
	}

	public void setDetailsDescribe(String detailsDescribe) {
		this.detailsDescribe = detailsDescribe;
	}

	public String getProductItemId() {
		return productItemId;
	}

	public void setProductItemId(String productItemId) {
		this.productItemId = productItemId;
	}

	@Override
	public String toString() {
		return "CloudProductLabelEntity{" +
				"title='" + title + '\'' +
				", labelType='" + labelType + '\'' +
				", labelDescribe='" + labelDescribe + '\'' +
				", banner='" + banner + '\'' +
				", sortNumber=" + sortNumber +
				", detailsDesc='" + detailsDesc + '\'' +
				", detailsTitle='" + detailsTitle + '\'' +
				", detailsDescribe='" + detailsDescribe + '\'' +
				", productItemId='" + productItemId + '\'' +
				'}';
	}
}
