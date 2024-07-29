package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 这是一个用于存储产品方案的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("product_solution")
@Data
public class ProductSolutionEntity extends InfraBaseEntity {

	/**
	 * 产品ID
	 */
	@TableField("product_item_id")
	@ColumnComment("产品ID")
	private Long productItemId;

	/**
	 * 方案ID
	 */
	@TableField("solution_id")
	@ColumnComment("方案ID")
	private Long solutionId;




}
