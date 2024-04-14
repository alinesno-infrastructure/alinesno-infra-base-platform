package com.alinesno.infra.base.platform.service.impl;

import com.alinesno.infra.base.platform.entity.ProductApplyEntity;
import com.alinesno.infra.base.platform.mapper.ProductApplyMapper;
import com.alinesno.infra.base.platform.service.IProductApplyService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductApplyServiceImpl extends IBaseServiceImpl<ProductApplyEntity, ProductApplyMapper> implements IProductApplyService {

}
