package com.alinesno.infra.base.platform.service;

import com.alinesno.infra.base.platform.api.dto.ProductItemDto;
import com.alinesno.infra.base.platform.entity.ProductItemEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

import java.util.Collection;
import java.util.List;

/**
 *
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public interface IProductItemService extends IBaseService<ProductItemEntity> {

    /**
     * 保存产品信息
     * @param productItemDto
     */
    void saveOrgProduct(ProductItemDto productItemDto);

    /**
     * 根据类型编码查询产品信息
     * @param typeCode
     * @return
     */
    List<ProductItemDto> queryProductByTypeCode(String typeCode);

    /**
     * 根据分类ID查询产品信息
     * @param categoryId
     * @return
     */
    List<ProductItemDto> findByCategoryId(Long categoryId);
}
