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
import lombok.experimental.Accessors;

/**
 * 会话频道
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("agent_role")
@Table(name = "智能体角色")
public class AgentRoleEntity extends InfraBaseEntity {

    @TableField("role_avatar")
    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 128)
    @ColumnComment("角色头像")
    private String roleAvatar;

    @TableField("role_name")
    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 100)
    @ColumnComment("角色名称")
    private String roleName;

    @TableField("responsibilities")
    @ColumnType(value = MySqlTypeConstant.VARCHAR)
    @ColumnComment("角色职责描述")
    private String responsibilities;

    @TableField("role_level")
    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 50)
    @ColumnComment("角色等级")
    private String roleLevel;

    @TableField("role_link")
    @ColumnType(value = MySqlTypeConstant.VARCHAR)
    @ColumnComment("角色链接")
    private String roleLink;

    @TableField("order_number")
    @ColumnType(value = MySqlTypeConstant.INT)
    @ColumnComment("排序号")
    private int orderNumber ;

}