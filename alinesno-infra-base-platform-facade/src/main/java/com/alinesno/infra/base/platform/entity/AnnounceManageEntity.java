package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 这是一个用于存储公告管理的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("announce_manage")
@Data
public class AnnounceManageEntity extends InfraBaseEntity {

	/**
	 * 标题
	 */
	@TableField("title")
	@ColumnComment("标题")
	private Long title;

	/**
	 * 公告内容
	 */
	@TableField("content")
	@ColumnComment("公告内容")
	private String content;

	/**
	 * 公告附件地址
	 */
	@TableField("file_path")
	@ColumnComment("公告附件地址")
	private String filePath;

}
