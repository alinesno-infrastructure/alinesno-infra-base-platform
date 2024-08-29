package com.alinesno.infra.base.platform.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alinesno.infra.base.platform.api.dto.ContentDto;
import com.alinesno.infra.base.platform.entity.ContentEntity;
import com.alinesno.infra.base.platform.mapper.ContentMapper;
import com.alinesno.infra.base.platform.service.IContentService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ContentServiceImpl extends IBaseServiceImpl<ContentEntity, ContentMapper> implements IContentService {

    @Override
    public List<ContentDto> getContentListByType(String type) {
        log.debug("getContentListByType:{}", type);

        LambdaQueryWrapper<ContentEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ContentEntity::getCategory, type);
        List<ContentEntity> contentList = this.list(queryWrapper);

        if (contentList != null && !contentList.isEmpty()) {
            return contentList.stream().map(item -> {
                log.debug("convertToDto:{}", item);

                ContentDto dto = new ContentDto();
                BeanUtil.copyProperties(item , dto) ;

                return dto ;
            }).toList();
        }

        return null;
    }

    @Override
    public ContentDto getContentDetail(long id) {
        if (id > 0) {
            ContentEntity content = this.getById(id);
            if (content != null) {
                ContentDto dto = new ContentDto();
                BeanUtil.copyProperties(content , dto) ;

                return dto ;
            }
        }
        return null;
    }

    @Override
    public void updateViewCount(long id) {
        ContentEntity content = this.getById(id);
        if (content != null) {
            content.setViewCount(content.getViewCount() + 1);
            this.updateById(content);
        }
    }
}
