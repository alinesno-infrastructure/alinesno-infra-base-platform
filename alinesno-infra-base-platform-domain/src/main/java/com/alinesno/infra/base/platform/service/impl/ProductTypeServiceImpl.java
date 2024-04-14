package com.alinesno.infra.base.platform.service.impl;

import com.alinesno.infra.base.platform.entity.ProductTypeEntity;
import com.alinesno.infra.base.platform.mapper.ProductTypeMapper;
import com.alinesno.infra.base.platform.service.IProductTypeService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductTypeServiceImpl extends IBaseServiceImpl<ProductTypeEntity, ProductTypeMapper> implements IProductTypeService {

}
