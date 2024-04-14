package com.alinesno.infra.base.platform.service.impl;

import com.alinesno.infra.base.platform.entity.ContentEntity;
import com.alinesno.infra.base.platform.mapper.ContentMapper;
import com.alinesno.infra.base.platform.service.IContentService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContentServiceImpl extends IBaseServiceImpl<ContentEntity, ContentMapper> implements IContentService {

}
