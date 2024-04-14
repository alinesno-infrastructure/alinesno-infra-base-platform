package com.alinesno.infra.base.platform.service.impl;

import com.alinesno.infra.base.platform.entity.DocumentEntity;
import com.alinesno.infra.base.platform.mapper.DocumentMapper;
import com.alinesno.infra.base.platform.service.IDocumentService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DocumentServiceImpl extends IBaseServiceImpl<DocumentEntity, DocumentMapper> implements IDocumentService {

}
