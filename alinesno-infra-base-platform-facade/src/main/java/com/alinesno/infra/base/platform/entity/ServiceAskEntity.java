package com.alinesno.infra.base.platform.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alibaba.fastjson.annotation.JSONField;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 云服务咨询实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("service_ask")
@Data
public class ServiceAskEntity extends InfraBaseEntity {

	/**
	 * 留言类型
	 */
	@TableField("service_type_id")
	@ColumnType(length=255)
	@ColumnComment("留言类型")
	private String serviceTypeId;

	/**
	 * 创建者
	 */
	@TableField("creator_id")
	@ColumnType(length=255)
	@ColumnComment("创建者")
	private String creatorId;

	/**
	 * 回复者
	 */
	@TableField("replyer_id")
	@ColumnType(length=255)
	@ColumnComment("回复者")
	private String replyerId;

	/**
	 * 咨询标题
	 */
	@TableField("ask_title")
	@ColumnType(length=255)
	@ColumnComment("咨询标题")
	private String askTitle;

	/**
	 * 咨询内容
	 */
	@TableField("ask_text")
	@ColumnType(length=255)
	@ColumnComment("咨询内容")
	private String askText;

	/**
	 * 咨询日期
	 */
	@TableField("creation_date")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@ColumnType(length=255)
	@ColumnComment("咨询日期")
	private Date creationDate;

	/**
	 * 咨询IP
	 */
	@TableField("creation_ip")
	@ColumnType(length=255)
	@ColumnComment("咨询IP")
	private String creationIp;

	/**
	 * 咨询地区
	 */
	@TableField("creation_area")
	@ColumnType(length=255)
	@ColumnComment("咨询地区")
	private String creationArea;

	/**
	 * 回复内容
	 */
	@TableField("reply_text")
	@ColumnType(length=255)
	@ColumnComment("回复内容")
	private String replyText;

	/**
	 * 回复日期
	 */
	@TableField("reply_date")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@ColumnType(length=255)
	@ColumnComment("回复日期")
	private Date replyDate;

	/**
	 * 回复IP
	 */
	@TableField("reply_ip")
	@ColumnType(length=255)
	@ColumnComment("回复IP")
	private String replyIp;

	/**
	 * 回复地区
	 */
	@TableField("reply_area")
	@ColumnType(length=255)
	@ColumnComment("回复地区")
	private String replyArea;

	/**
	 * 是否回复
	 */
	@TableField("is_reply")
	@ColumnType(length=255)
	@ColumnComment("是否回复")
	private String isReply;

	/**
	 * 是否推荐
	 */
	@TableField("is_recommend")
	@ColumnType(length=255)
	@ColumnComment("是否推荐")
	private String isRecommend;

	/**
	 * 咨询状态
	 * 0：已审核
	 * 1：未审核
	 * 2：屏蔽
	 */
	@TableField("guestbook_status")
	@ColumnType(length=255)
	@ColumnComment("咨询状态")
	private Integer guestbookStatus;

	/**
	 * 用户名
	 */
	@TableField("username")
	@ColumnType(length=255)
	@ColumnComment("用户名")
	private String username;

	/**
	 * 性别
	 */
	@TableField("creation_gender")
	@ColumnType(length=255)
	@ColumnComment("性别")
	private String creationGender;

	/**
	 * 电话
	 */
	@TableField("creation_phone")
	@ColumnType(length=255)
	@ColumnComment("电话")
	private String creationPhone;

	/**
	 * 手机
	 */
	@TableField("creation_mobile")
	@ColumnType(length=255)
	@ColumnComment("手机")
	private String creationMobile;

	/**
	 * QQ号码
	 */
	@TableField("creation_qq")
	@ColumnType(length=255)
	@ColumnComment("QQ号码")
	private String creationQq;

	/**
	 * 电子邮箱
	 */
	@TableField("creation_email")
	@ColumnType(length=255)
	@ColumnComment("电子邮箱")
	private String creationEmail;
}
