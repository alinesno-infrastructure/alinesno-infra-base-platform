package com.alinesno.infra.base.platform.service.impl;

import com.alinesno.infra.base.platform.entity.AppScreenEntity;
import com.alinesno.infra.base.platform.mapper.AppScreenMapper;
import com.alinesno.infra.base.platform.service.IAppScreenService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AppScreenServiceImpl extends IBaseServiceImpl<AppScreenEntity, AppScreenMapper> implements IAppScreenService {

}
