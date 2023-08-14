package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 应用屏幕实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("app_screen")
public class AppScreenEntity extends InfraBaseEntity {

    /**
     * 图标
     */
    @TableField
    private String icon;

    /**
     * 标题
     */
    @TableField
    private String title;

    /**
     * 备注
     */
    @TableField
    private String remark;

    /**
     * 排序
     */
    @TableField
    private Integer screenIndex;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getScreenIndex() {
        return screenIndex;
    }

    public void setScreenIndex(Integer screenIndex) {
        this.screenIndex = screenIndex;
    }
}
