package com.alinesno.infra.base.platform.api;

import com.alinesno.infra.common.facade.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 表示控制台界面中的菜单项，封装了菜单项的基本属性。
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Data
public class MenuItemDto extends BaseDto {

    /**
     * 菜单项的状态，用于指示菜单项是否可用。
     */
    private int status;

    /**
     * 菜单项的图标，用于显示菜单项的图标信息。
     */
    private String icon;

    /**
     * 菜单项的名称，用于显示菜单项的文字信息。
     */
    private String name;

    /**
     * 菜单项的类型，用于区分不同类型的菜单项。
     */
    private String type;

    /**
     * 菜单项的路径，用于指定菜单项的访问路径。
     */
    private String path;

    /**
     * 菜单项的描述，用于提供菜单项的详细描述。
     */
    private String desc;

    public MenuItemDto() {
    }

    /**
     * 构造函数。
     * 使用指定的状态、图标、名称、类型、路径和描述初始化一个菜单项。
     *
     * @param status 菜单项的状态
     * @param icon 菜单项的图标
     * @param name 菜单项的名称
     * @param type 菜单项的类型
     * @param path 菜单项的路径
     * @param desc 菜单项的描述
     */
    public MenuItemDto(int status, String icon, String name, String type, String path, String desc) {
        this.status = status;
        this.icon = icon;
        this.name = name;
        this.type = type;
        this.path = path;
        this.desc = desc;
    }
}
