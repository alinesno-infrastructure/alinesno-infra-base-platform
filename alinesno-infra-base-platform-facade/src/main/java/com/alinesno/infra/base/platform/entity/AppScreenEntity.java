package com.alinesno.infra.base.platform.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

/**
 * 应用屏幕实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("app_screen")
@Data
public class AppScreenEntity extends InfraBaseEntity {

    /**
     * 图标
     */
    @TableField
	@ColumnType(length=50)
	@ColumnComment("图标")
    private String icon;

    /**
     * 标题
     */
    @TableField
	@ColumnType(length=255)
	@ColumnComment("标题")
    private String title;

    /**
     * 备注
     */
    @TableField
	@ColumnType(length=255)
	@ColumnComment("备注")
    private String remark;

    /**
     * 排序
     */
    @TableField
	@ColumnType(length=2)
	@ColumnComment("排序")
    private Integer screenIndex;
}
