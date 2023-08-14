package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 解决方案标签实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("cloud_solution_label")
public class CloudSolutionLabelEntity extends InfraBaseEntity {

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
	 * 排序
	 */
	@TableField("sort_number")
	private Integer sortNumber;

	/**
	 * 所属解决方案id
	 */
	@TableField("solution_article_id")
	private String solutionArticleId;

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

	public Integer getSortNumber() {
		return sortNumber;
	}

	public void setSortNumber(Integer sortNumber) {
		this.sortNumber = sortNumber;
	}

	public String getSolutionArticleId() {
		return solutionArticleId;
	}

	public void setSolutionArticleId(String solutionArticleId) {
		this.solutionArticleId = solutionArticleId;
	}

	@Override
	public String toString() {
		return "CloudSolutionLabelEntity{" +
				"title='" + title + '\'' +
				", labelType='" + labelType + '\'' +
				", labelDescribe='" + labelDescribe + '\'' +
				", sortNumber=" + sortNumber +
				", solutionArticleId='" + solutionArticleId + '\'' +
				'}';
	}
}
