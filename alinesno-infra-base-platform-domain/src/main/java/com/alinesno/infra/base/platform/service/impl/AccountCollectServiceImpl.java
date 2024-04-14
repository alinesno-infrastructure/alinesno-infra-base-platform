package com.alinesno.infra.base.platform.service.impl;

import com.alinesno.infra.base.platform.entity.AccountCollectEntity;
import com.alinesno.infra.base.platform.mapper.AccountCollectMapper;
import com.alinesno.infra.base.platform.service.IAccountCollectService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountCollectServiceImpl extends IBaseServiceImpl<AccountCollectEntity, AccountCollectMapper> implements IAccountCollectService {

}
