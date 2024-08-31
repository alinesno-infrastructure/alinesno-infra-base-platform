package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 频道里面的角色实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("account_channel")
@Table(name = "用户收藏频道")
public class AccountChannelEntity extends InfraBaseEntity {

    @TableField("agent_id")
    @ColumnType
    @ColumnComment("所属频道ID")
    private Long agentId; // 所属频道ID

    @TableField("role_name")
    @ColumnType(length=255)
    @ColumnComment("角色名称")
    private String roleName; // 角色名称

    @TableField("role_description")
    @ColumnType(length=255)
    @ColumnComment("角色描述")
    private String roleDescription; // 角色描述

    @TableField("permissions")
    @ColumnType(length=255)
    @ColumnComment("权限列表")
    private String permissions; // 权限列表（可以是逗号分隔的权限标识）

    @TableField("status")
    @ColumnType(length=255)
    @ColumnComment("状态")
    private Integer status; // 状态（如：启用、禁用等）

    @TableField("avatar")
    @ColumnType(MySqlTypeConstant.LONGTEXT)
    @ColumnComment("头像，base64图片显示")
    private String avatar; // 头像URL

}