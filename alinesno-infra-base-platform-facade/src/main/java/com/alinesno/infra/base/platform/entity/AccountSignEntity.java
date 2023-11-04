package com.alinesno.infra.base.platform.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 账号签到实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("account_sign")
@Data
public class AccountSignEntity extends InfraBaseEntity {

	/**
	 * 今天是否已签到
	 */
	@TableField("has_day_sign")
	@ColumnType(length=1)
	@ColumnComment("今天是否已签到")
	private int hasDaySign;

	/**
	 * 签到天数
	 */
	@TableField("sign_day_count")
	@ColumnType(length=255)
	@ColumnComment("签到天数")
	private int signDayCount;

	/**
	 * 成长值
	 */
	@TableField("growth_value")
	@ColumnType(length=10)
	@ColumnComment("成长值")
	private int growthValue;
}
