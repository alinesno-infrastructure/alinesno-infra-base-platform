package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 解决方案类型实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("cloud_solution_type")
public class CloudSolutionTypeEntity extends InfraBaseEntity {

	/**
	 * 名称
	 */
	@TableField("name")
	private String name;

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
	 * 父类id
	 */
	@TableField("parent_id")
	private String parentId;

	/**
	 * 子名称
	 */
	@TableField("sub_name")
	private String subName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	@Override
	public String toString() {
		return "CloudSolutionTypeEntity{" +
				"name='" + name + '\'' +
				", labelDescribe='" + labelDescribe + '\'' +
				", banner='" + banner + '\'' +
				", sortNumber=" + sortNumber +
				", parentId='" + parentId + '\'' +
				", subName='" + subName + '\'' +
				'}';
	}
}
