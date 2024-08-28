package com.alinesno.infra.base.platform.api;

import com.alinesno.infra.common.facade.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 这是一个用于存储云反馈的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FeedbackDto extends BaseDto {

	private String typeCode; // 建议类型
	private long grade ; // 评分
	private String title; // 标题
	private String problemDesc; // 建议内容
	private String proposedSolution;
	private String productItemId;
	private long accountId;
}
