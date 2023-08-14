package com.alinesno.infra.base.platform.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * 云服务咨询实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("service_ask")
public class CloudServiceAskEntity extends InfraBaseEntity {

	/**
	 * 留言类型
	 */
	@TableField("service_type_id")
	private String serviceTypeId;

	/**
	 * 创建者
	 */
	@TableField("creator_id")
	private String creatorId;

	/**
	 * 回复者
	 */
	@TableField("replyer_id")
	private String replyerId;

	/**
	 * 咨询标题
	 */
	@TableField("ask_title")
	private String askTitle;

	/**
	 * 咨询内容
	 */
	@TableField("ask_text")
	private String askText;

	/**
	 * 咨询日期
	 */
	@TableField("creation_date")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date creationDate;

	/**
	 * 咨询IP
	 */
	@TableField("creation_ip")
	private String creationIp;

	/**
	 * 咨询地区
	 */
	@TableField("creation_area")
	private String creationArea;

	/**
	 * 回复内容
	 */
	@TableField("reply_text")
	private String replyText;

	/**
	 * 回复日期
	 */
	@TableField("reply_date")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date replyDate;

	/**
	 * 回复IP
	 */
	@TableField("reply_ip")
	private String replyIp;

	/**
	 * 回复地区
	 */
	@TableField("reply_area")
	private String replyArea;

	/**
	 * 是否回复
	 */
	@TableField("is_reply")
	private String isReply;

	/**
	 * 是否推荐
	 */
	@TableField("is_recommend")
	private String isRecommend;

	/**
	 * 咨询状态
	 * 0：已审核
	 * 1：未审核
	 * 2：屏蔽
	 */
	@TableField("guestbook_status")
	private Integer guestbookStatus;

	/**
	 * 用户名
	 */
	@TableField("username")
	private String username;

	/**
	 * 性别
	 */
	@TableField("creation_gender")
	private String creationGender;

	/**
	 * 电话
	 */
	@TableField("creation_phone")
	private String creationPhone;

	/**
	 * 手机
	 */
	@TableField("creation_mobile")
	private String creationMobile;

	/**
	 * QQ号码
	 */
	@TableField("creation_qq")
	private String creationQq;

	/**
	 * 电子邮箱
	 */
	@TableField("creation_email")
	private String creationEmail;

	// 省略getter和setter方法

	@Override
	public String toString() {
		return "CloudServiceAskEntity{" +
				"serviceTypeId='" + serviceTypeId + '\'' +
				", creatorId='" + creatorId + '\'' +
				", replyerId='" + replyerId + '\'' +
				", askTitle='" + askTitle + '\'' +
				", askText='" + askText + '\'' +
				", creationDate=" + creationDate +
				", creationIp='" + creationIp + '\'' +
				", creationArea='" + creationArea + '\'' +
				", replyText='" + replyText + '\'' +
				", replyDate=" + replyDate +
				", replyIp='" + replyIp + '\'' +
				", replyArea='" + replyArea + '\'' +
				", isReply='" + isReply + '\'' +
				", isRecommend='" + isRecommend + '\'' +
				", guestbookStatus=" + guestbookStatus +
				", username='" + username + '\'' +
				", creationGender='" + creationGender + '\'' +
				", creationPhone='" + creationPhone + '\'' +
				", creationMobile='" + creationMobile + '\'' +
				", creationQq='" + creationQq + '\'' +
				", creationEmail='" + creationEmail + '\'' +
				'}';
	}
}
