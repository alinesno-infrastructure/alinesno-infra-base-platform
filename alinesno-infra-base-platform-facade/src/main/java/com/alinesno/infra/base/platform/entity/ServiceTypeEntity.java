package com.alinesno.infra.base.platform.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

/**
 * 服务类型实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("service_type")
@Data
public class ServiceTypeEntity extends InfraBaseEntity {

	@ColumnType(length=255)
	@ColumnComment("服务类型实体类")
	@TableField("fina")
	private static final long serialVersionUID = 1L;

	/**
	 * 名称
	 */
	@TableField("service_type_name")
	@ColumnType(length=255)
	@ColumnComment("名称")
	private String serviceTypeName;

	/**
	 * 编码
	 */
	@TableField("service_type_number")
	@ColumnType(length=255)
	@ColumnComment("编码")
	private String serviceTypeNumber;

	/**
	 * 排序
	 */
	@TableField("service_type_seq")
	@ColumnType(length=255)
	@ColumnComment("排序")
	private Integer serviceTypeSeq;

	/**
	 * 描述
	 */
	@TableField("service_type_desc")
	@ColumnType(length=255)
	@ColumnComment("描述")
	private String serviceTypeDesc;
}
