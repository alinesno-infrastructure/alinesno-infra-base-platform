package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 这是一个用于存储云链接路径的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("cloud_link_path")
public class CloudLinkPathEntity extends InfraBaseEntity {

	/**
	 * 链接类型
	 */
	@TableField("link_type")
	private String linkType;

	/**
	 * 链接名称
	 */
	@TableField("link_name")
	private String linkName;

	/**
	 * 链接地址
	 */
	@TableField("link_path")
	private String linkPath;

	/**
	 * 链接描述
	 */
	@TableField("link_desc")
	private String linkDesc;

	/**
	 * 链接打开状态
	 */
	@TableField("link_target")
	private String linkTarget;

	/**
	 * 链接状态
	 */
	@TableField("link_design")
	private String linkDesign;

	/**
	 * 链接排序
	 */
	@TableField("link_sort")
	private Integer linkSort;

	public String getLinkType() {
		return linkType;
	}

	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkPath() {
		return linkPath;
	}

	public void setLinkPath(String linkPath) {
		this.linkPath = linkPath;
	}

	public String getLinkDesc() {
		return linkDesc;
	}

	public void setLinkDesc(String linkDesc) {
		this.linkDesc = linkDesc;
	}

	public String getLinkTarget() {
		return linkTarget;
	}

	public void setLinkTarget(String linkTarget) {
		this.linkTarget = linkTarget;
	}

	public String getLinkDesign() {
		return linkDesign;
	}

	public void setLinkDesign(String linkDesign) {
		this.linkDesign = linkDesign;
	}

	public Integer getLinkSort() {
		return linkSort;
	}

	public void setLinkSort(Integer linkSort) {
		this.linkSort = linkSort;
	}

	@Override
	public String toString() {
		return "CloudLinkPathEntity{" +
				"linkType='" + linkType + '\'' +
				", linkName='" + linkName + '\'' +
				", linkPath='" + linkPath + '\'' +
				", linkDesc='" + linkDesc + '\'' +
				", linkTarget='" + linkTarget + '\'' +
				", linkDesign='" + linkDesign + '\'' +
				", linkSort=" + linkSort +
				'}';
	}
}
