package com.alinesno.infra.base.platform.service.impl;


import com.alinesno.infra.base.platform.entity.ProductAccessInfoEntity;
import com.alinesno.infra.base.platform.mapper.ProductAccessInfoMapper;
import com.alinesno.infra.base.platform.service.IProductAccessInfoService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductAccessInfoServiceImpl extends IBaseServiceImpl<ProductAccessInfoEntity, ProductAccessInfoMapper> implements IProductAccessInfoService {

}
