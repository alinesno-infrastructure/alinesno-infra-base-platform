package com.alinesno.infra.base.platform.gateway.controller;

import com.alinesno.infra.base.platform.entity.ProductItemEntity;
import com.alinesno.infra.base.platform.service.IProductItemService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.extend.datasource.annotation.DataPermissionSave;
import com.alinesno.infra.common.extend.datasource.annotation.DataPermissionScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 处理与ProductItemEntity相关的请求的Controller。
 * 继承自BaseController类并实现IProductItemService接口。
 *
 * @author LuoXiaoDong
 * @version 1.0.0
 */
@Slf4j
@Api(tags = "ProductItem")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/platform/productItem")
public class ProductItemController extends BaseController<ProductItemEntity, IProductItemService> {

    @Autowired
    private IProductItemService service;

    /**
     * 获取ProductItemEntity的DataTables数据。
     *
     * @param request HttpServletRequest对象。
     * @param model   Model对象。
     * @param page    DatatablesPageBean对象。
     * @return 包含DataTables数据的TableDataInfo对象。
     */
    @DataPermissionScope
    @ResponseBody
    @PostMapping("/datatables")
    public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
        log.debug("page = {}", ToStringBuilder.reflectionToString(page));
        return this.toPage(model, this.getFeign(), page);
    }

    @DataPermissionSave
    @Override
    public AjaxResult save(Model model, @RequestBody ProductItemEntity entity) throws Exception {
        return super.save(model, entity);
    }

    @Override
    public IProductItemService getFeign() {
        return this.service;
    }
}
