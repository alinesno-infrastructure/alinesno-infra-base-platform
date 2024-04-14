package com.alinesno.infra.base.platform.service.impl;

import com.alinesno.infra.base.platform.entity.AccountAuditEntity;
import com.alinesno.infra.base.platform.entity.AccountProductItemEntity;
import com.alinesno.infra.base.platform.mapper.AccountAuditMapper;
import com.alinesno.infra.base.platform.mapper.AccountProductItemMapper;
import com.alinesno.infra.base.platform.service.IAccountAuditService;
import com.alinesno.infra.base.platform.service.IAccountProductItemService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountProductItemServiceImpl extends IBaseServiceImpl<AccountProductItemEntity, AccountProductItemMapper> implements IAccountProductItemService {

}
