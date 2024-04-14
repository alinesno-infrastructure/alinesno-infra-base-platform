package com.alinesno.infra.base.platform.service.impl;

import com.alinesno.infra.base.platform.entity.AccountSignEntity;
import com.alinesno.infra.base.platform.mapper.AccountSignMapper;
import com.alinesno.infra.base.platform.service.IAccountSignService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountSignServiceImpl extends IBaseServiceImpl<AccountSignEntity, AccountSignMapper> implements IAccountSignService {

}
