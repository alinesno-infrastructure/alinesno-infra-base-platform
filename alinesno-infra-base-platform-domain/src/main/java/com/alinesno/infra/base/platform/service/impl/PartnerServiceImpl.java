package com.alinesno.infra.base.platform.service.impl;

import com.alinesno.infra.base.platform.entity.PartnerEntity;
import com.alinesno.infra.base.platform.mapper.PartnerMapper;
import com.alinesno.infra.base.platform.service.IPartnerService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PartnerServiceImpl extends IBaseServiceImpl<PartnerEntity, PartnerMapper> implements IPartnerService {

}
