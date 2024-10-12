package com.alinesno.infra.base.platform.service.impl;

import com.alinesno.infra.base.platform.entity.AccountChannelEntity;
import com.alinesno.infra.base.platform.mapper.AccountChannelMapper;
import com.alinesno.infra.base.platform.service.IAccountChannelService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountChannelServiceImpl extends IBaseServiceImpl<AccountChannelEntity, AccountChannelMapper> implements IAccountChannelService {

}
