package com.alinesno.infra.base.platform.gateway.provider;

import com.alinesno.infra.base.platform.api.dto.SolutionDto;
import com.alinesno.infra.base.platform.service.ISolutionManageService;
import com.alinesno.infra.common.facade.response.R;
import com.alinesno.infra.common.web.adapter.rest.SuperController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 解决方案列表
 */
@Slf4j
@RestController
@RequestMapping("/api/infra/base/platform/provider/solution")
public class SolutionRest extends SuperController {

    @Autowired
    private ISolutionManageService solutionManageService;

    /**
     * 获取到最新的解决方式
     */
    @GetMapping("/getNewSolution")
    public R<List<SolutionDto>> getNewSolution(@RequestParam(required = false) Integer count) {

        count = (count != null && count > 0) ? count : 3 ;
        List<SolutionDto> result = solutionManageService.getNewSolution(count);

        return R.ok(result) ;
    }

}
