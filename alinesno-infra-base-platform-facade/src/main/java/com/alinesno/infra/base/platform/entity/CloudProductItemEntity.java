package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 这是一个用于存储云产品项信息的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("cloud_product_item")
public class CloudProductItemEntity extends InfraBaseEntity {

	/**
	 * 产品名称
	 */
	@TableField("name")
	private String name;

	/**
	 * 排序
	 */
	@TableField("sort_number")
	private Integer sortNumber;

	/**
	 * 产品简介
	 */
	@TableField("product_brief")
	private String productBrief;

	/**
	 * 产品描述
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
	 * 产品链接
	 */
	@TableField("link_path")
	private String linkPath;

	/**
	 * 当前状态(规划planning|研究research|生产production)
	 */
	@TableField("item_status")
	private String itemStatus;

	/**
	 * 产品状态(正常normal|内测internal|公测public)
	 */
	@TableField("prod_status")
	private String prodStatus;

	/**
	 * 标识状态(0启用|1禁用)
	 */
	@TableField("identity_status")
	private String identityStatus;

	/**
	 * 所属类型id
	 */
	@TableField("product_type_id")
	private String productTypeId;

	/**
	 * 是否推荐
	 */
	@TableField("has_recommend")
	private int hasRecommend;

	/**
	 * 是否内置链接(内置1|正常0)
	 */
	@TableField("has_inner")
	private int hasInner;

	public int getHasInner() {
		return hasInner;
	}

	public void setHasInner(int hasInner) {
		this.hasInner = hasInner;
	}

	public int getHasRecommend() {
		return hasRecommend;
	}

	public void setHasRecommend(int hasRecommend) {
		this.hasRecommend = hasRecommend;
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

}