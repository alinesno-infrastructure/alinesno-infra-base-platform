package com.alinesno.infra.base.platform.entity;

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
public class AccountSignEntity extends InfraBaseEntity {

	/**
	 * 今天是否已签到
	 */
	@TableField("has_day_sign")
	private int hasDaySign;

	/**
	 * 签到天数
	 */
	@TableField("sign_day_count")
	private int signDayCount;

	/**
	 * 成长值
	 */
	@TableField("growth_value")
	private int growthValue;

	public int isHasDaySign() {
		return hasDaySign;
	}

	public void setHasDaySign(int hasDaySign) {
		this.hasDaySign = hasDaySign;
	}

	public int getSignDayCount() {
		return signDayCount;
	}

	public void setSignDayCount(int signDayCount) {
		this.signDayCount = signDayCount;
	}

	public int getGrowthValue() {
		return growthValue;
	}

	public void setGrowthValue(int growthValue) {
		this.growthValue = growthValue;
	}
}
