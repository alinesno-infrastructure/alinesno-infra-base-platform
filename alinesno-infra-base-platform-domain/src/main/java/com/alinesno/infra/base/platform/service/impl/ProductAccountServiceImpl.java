package com.alinesno.infra.base.platform.service.impl;

import com.alinesno.infra.base.platform.entity.ProductAccountEntity;
import com.alinesno.infra.base.platform.mapper.ProductAccountMapper;
import com.alinesno.infra.base.platform.service.IProductAccountService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductAccountServiceImpl extends IBaseServiceImpl<ProductAccountEntity, ProductAccountMapper> implements IProductAccountService {

}
