package com.alinesno.infra.base.platform.service.impl;


import com.alinesno.infra.base.platform.api.dto.SolutionDto;
import com.alinesno.infra.base.platform.entity.SolutionManageEntity;
import com.alinesno.infra.base.platform.mapper.SolutionManageMapper;
import com.alinesno.infra.base.platform.service.ISolutionManageService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SolutionManageServiceImpl extends IBaseServiceImpl<SolutionManageEntity, SolutionManageMapper> implements ISolutionManageService {

    @Override
    public List<SolutionDto> getNewSolution(int count) {

        if (count > 0){
            LambdaQueryWrapper<SolutionManageEntity> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.orderByDesc(SolutionManageEntity::getAddTime);
            queryWrapper.last("limit " + count);
            List<SolutionManageEntity> solutionManageEntities = this.list(queryWrapper);

            return solutionManageEntities.stream().map(item -> new SolutionDto(item.getTitle(), item.getContent(), item.getLink(), item.getAddTime())).toList();
        }

        return null;
    }
}
