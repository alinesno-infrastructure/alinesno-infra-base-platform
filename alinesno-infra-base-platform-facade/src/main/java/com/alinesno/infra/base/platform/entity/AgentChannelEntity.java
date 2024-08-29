package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 会话频道
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("agent_channel")
@Table(name = "会话频道")
public class AgentChannelEntity extends InfraBaseEntity {

    @TableField("name")
    @ColumnType(length=32)
    @ColumnComment("频道名称")
    private String name; // Channel name

    @TableField("description")
    @ColumnType(length=255)
    @ColumnComment("频道描述")
    private String description; // Channel description

    @TableField("type")
    @ColumnType(length=32)
    @ColumnComment("频道类型")
    private String type; // Channel type (e.g., public, private)

    @TableField("status")
    @ColumnType(length=32)
    @ColumnComment("频道状态")
    private String status; // Channel status (e.g., active, inactive)

    @TableField("creator_id")
    @ColumnType(length=32)
    @ColumnComment("创建者ID")
    private long creatorId; // Creator ID

    @TableField("creator_name")
    @ColumnType(length=32)
    @ColumnComment("创建者名称")
    private String creatorName;// Creator name

    // 图片
    @TableField("image")
    @ColumnType(length=255)
    @ColumnComment("频道图片")
    private String image;

}