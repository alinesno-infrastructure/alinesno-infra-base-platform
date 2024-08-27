package com.alinesno.infra.base.platform.gateway.controller;

import com.alinesno.infra.base.platform.entity.SolutionManageEntity;
import com.alinesno.infra.base.platform.service.ISolutionManageService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理与SolutionManageEntity相关的请求的Controller。
 * 继承自BaseController类并实现ISolutionManageService接口。
 *
 * @author LuoXiaoDong
 * @version 1.0.0
 */
@Slf4j
@Api(tags = "AccountAudit")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/platform/SolutionManage")
public class SolutionManageController extends BaseController<SolutionManageEntity, ISolutionManageService> {

    @Autowired
    private ISolutionManageService service;

    /**
     * 获取SolutionManageEntity的DataTables数据。
     *
     * @param request HttpServletRequest对象。
     * @param model   Model对象。
     * @param page    DatatablesPageBean对象。
     * @return 包含DataTables数据的TableDataInfo对象。
     */
    @ResponseBody
    @PostMapping("/datatables")
    public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
        log.debug("page = {}", ToStringBuilder.reflectionToString(page));
        return this.toPage(model, this.getFeign(), page);
    }

    @Override
    public ISolutionManageService getFeign() {
        return this.service;
    }
}
