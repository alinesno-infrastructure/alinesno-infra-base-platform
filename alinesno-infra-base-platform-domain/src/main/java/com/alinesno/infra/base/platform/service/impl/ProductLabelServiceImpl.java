package com.alinesno.infra.base.platform.service.impl;

import com.alinesno.infra.base.platform.entity.ProductLabelEntity;
import com.alinesno.infra.base.platform.mapper.ProductLabelMapper;
import com.alinesno.infra.base.platform.service.IProductLabelService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductLabelServiceImpl extends IBaseServiceImpl<ProductLabelEntity, ProductLabelMapper> implements IProductLabelService {

}
