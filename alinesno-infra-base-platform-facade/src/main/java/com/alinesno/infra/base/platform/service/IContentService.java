package com.alinesno.infra.base.platform.service;

import com.alinesno.infra.base.platform.api.dto.ContentDto;
import com.alinesno.infra.base.platform.entity.ContentEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

import java.util.List;

/**
 *
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public interface IContentService extends IBaseService<ContentEntity> {

    /**
     * 根据类型获取内容列表
     * @param type
     * @return
     */
    List<ContentDto> getContentListByType(String type);

    /**
     * 获取内容详情
     * @param id
     * @return
     */
    ContentDto getContentDetail(long id);

    /**
     * 更新内容查看次数
     *
     * @param id
     */
    void updateViewCount(long id);
}
