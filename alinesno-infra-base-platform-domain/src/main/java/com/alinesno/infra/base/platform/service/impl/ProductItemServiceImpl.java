package com.alinesno.infra.base.platform.service.impl;

import com.alinesno.infra.base.platform.entity.ProductItemEntity;
import com.alinesno.infra.base.platform.mapper.ProductItemMapper;
import com.alinesno.infra.base.platform.service.IProductItemService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductItemServiceImpl extends IBaseServiceImpl<ProductItemEntity, ProductItemMapper> implements IProductItemService {

}
