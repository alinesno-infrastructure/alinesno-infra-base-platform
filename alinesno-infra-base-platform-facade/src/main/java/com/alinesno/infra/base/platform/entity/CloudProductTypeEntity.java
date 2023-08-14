package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 产品类型实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("cloud_product_type")
public class CloudProductTypeEntity extends InfraBaseEntity {

	/**
	 * 名称
	 */
	@TableField("name")
	private String name;

	/**
	 * 排序
	 */
	@TableField("sort_number")
	private Integer sortNumber;

	/**
	 * 背景图
	 */
	@TableField("banner")
	private String banner;

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

	/**
	 * 产品类型描述
	 */
	@TableField("type_describe")
	private String typeDescribe;

	public CloudProductTypeEntity() {
		super();
	}

	public CloudProductTypeEntity(String name, String typeDescribe) {
		super();
		this.name = name;
		this.typeDescribe = typeDescribe;
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

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
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

	public String getTypeDescribe() {
		return typeDescribe;
	}

	public void setTypeDescribe(String typeDescribe) {
		this.typeDescribe = typeDescribe;
	}

	@Override
	public String toString() {
		return "CloudProductTypeEntity{" +
				"name='" + name + '\'' +
				", sortNumber=" + sortNumber +
				", banner='" + banner + '\'' +
				", parentId='" + parentId + '\'' +
				", subName='" + subName + '\'' +
				", typeDescribe='" + typeDescribe + '\'' +
				'}';
	}
}
