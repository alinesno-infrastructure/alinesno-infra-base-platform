package com.alinesno.infra.base.platform.service;

import com.alinesno.infra.base.platform.api.dto.SolutionDto;
import com.alinesno.infra.base.platform.entity.SolutionManageEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

import java.util.List;

/**
 *
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public interface ISolutionManageService extends IBaseService<SolutionManageEntity> {

    /**
     * 获取最新的解决方案
     * @param count
     * @return
     */
    List<SolutionDto> getNewSolution(int count);

}
