package com.alinesno.infra.base.platform.service.impl;

import com.alinesno.infra.base.platform.entity.ServiceTypeEntity;
import com.alinesno.infra.base.platform.mapper.ServiceTypeMapper;
import com.alinesno.infra.base.platform.service.IServiceTypeService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ServiceTypeServiceImpl extends IBaseServiceImpl<ServiceTypeEntity, ServiceTypeMapper> implements IServiceTypeService {

}
