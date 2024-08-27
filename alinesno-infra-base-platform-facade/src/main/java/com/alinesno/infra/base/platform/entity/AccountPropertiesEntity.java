package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 账号签到实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("account_properties")
@Data
public class AccountPropertiesEntity extends InfraBaseEntity {

	/**
	 * 账号ID
	 */
	@TableField("account_id")
	@ColumnType
	@ColumnComment("账号ID")
	private long accountId;

	/**
	 * 账号属性
	 */
	@TableField("p_key")
	@ColumnType(length=255)
	@ColumnComment("账号属性")
	private String pKey ;

	/**
	 * 账号属性值
	 */
	@TableField("p_value")
	@ColumnType(MySqlTypeConstant.LONGTEXT)
	@ColumnComment("账号属性值")
	private String pValue ;

}
