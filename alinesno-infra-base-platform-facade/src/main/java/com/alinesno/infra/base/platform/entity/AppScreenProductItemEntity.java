package com.alinesno.infra.base.platform.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

/**
 * 场景应用产品项实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("app_screen_item")
@Data
public class AppScreenProductItemEntity extends InfraBaseEntity {

	/**
	 * 场景ID
	 */
	@TableField
	@ColumnType(length=50)
	@ColumnComment("场景ID")
	private String screenId;

	/**
	 * 项ID
	 */
	@TableField
	@ColumnType(length=50)
	@ColumnComment("项ID")
	private String itemId;

	/**
	 * 用户ID
	 */
	@TableField
	@ColumnType(length=50)
	@ColumnComment("用户ID")
	private String userId;
}
