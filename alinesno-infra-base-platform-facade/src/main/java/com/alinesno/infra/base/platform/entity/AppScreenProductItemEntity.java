package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 场景应用产品项实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("app_screen_item")
public class AppScreenProductItemEntity extends InfraBaseEntity {

	/**
	 * 场景ID
	 */
	@TableField
	private String screenId;

	/**
	 * 项ID
	 */
	@TableField
	private String itemId;

	/**
	 * 用户ID
	 */
	@TableField
	private String userId;

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
