package com.alinesno.infra.base.platform.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

/**
 * 这是一个用于存储云合作伙伴信息的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("partner")
@Data
public class PartnerEntity extends InfraBaseEntity {

	/**
	 * 合作伙伴类型
	 */
	@TableField("partner_type")
	@ColumnType(length=255)
	@ColumnComment("合作伙伴类型")
	private String partnerType;

	/**
	 * 公司logo
	 */
	@TableField("logo")
	@ColumnType(length=255)
	@ColumnComment("公司logo")
	private String logo;

	/**
	 * 公司名称
	 */
	@TableField("company_name")
	@ColumnType(length=255)
	@ColumnComment("公司名称")
	private String companyName;

	/**
	 * 联系电话
	 */
	@TableField("company_tel")
	@ColumnType(length=255)
	@ColumnComment("联系电话")
	private String companyTel;

	/**
	 * 联系邮箱
	 */
	@TableField("company_email")
	@ColumnType(length=255)
	@ColumnComment("联系邮箱")
	private String companyEmail;

	/**
	 * 公司地址
	 */
	@TableField("company_address")
	@ColumnType(length=255)
	@ColumnComment("公司地址")
	private String companyAddress;

	/**
	 * 公司简介
	 */
	@TableField("company_desc")
	@ColumnType(length=255)
	@ColumnComment("公司简介")
	private String companyDesc;

	/**
	 * 排序
	 */
	@TableField("sort_number")
	@ColumnType(length=255)
	@ColumnComment("排序")
	private Integer sortNumber;
}
