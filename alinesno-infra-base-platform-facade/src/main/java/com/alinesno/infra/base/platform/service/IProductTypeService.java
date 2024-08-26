package com.alinesno.infra.base.platform.service;

import com.alinesno.infra.base.platform.api.dto.ProductTypeDto;
import com.alinesno.infra.base.platform.entity.ProductTypeEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

import java.util.List;

/**
 *
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public interface IProductTypeService extends IBaseService<ProductTypeEntity> {

    /**
     * 根据组织ID查询产品分类
      * @param orgId
     * @return
     */
    List<ProductTypeDto> findByOrgId(String orgId);

    /**
     * 保存组织产品分类
     * @param productTypeDto
     */
    void saveOrgProductCategory(ProductTypeDto productTypeDto);
}
