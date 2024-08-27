package com.alinesno.infra.base.platform.service;

import com.alinesno.infra.base.platform.api.MenuItemDto;
import com.alinesno.infra.base.platform.entity.AccountPropertiesEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

import java.util.List;

/**
 *
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public interface IAccountPropertiesService extends IBaseService<AccountPropertiesEntity> {

    /**
     * 查询自定义菜单
     * @param orgId
     * @return
     */
    List<MenuItemDto> queryConstomView(long orgId);

    /**
     * 保存自定义菜单
     * @param menuItemDtoList
     * @param orgId
     */
    void saveCustomView(List<MenuItemDto> menuItemDtoList, long orgId);

}
