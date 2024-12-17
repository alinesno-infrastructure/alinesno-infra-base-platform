package com.alinesno.infra.base.platform.gateway.controller;

import com.alinesno.infra.base.platform.entity.ProductTypeEntity;
import com.alinesno.infra.base.platform.service.IProductTypeService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.extend.datasource.annotation.DataPermissionQuery;
import com.alinesno.infra.common.extend.datasource.annotation.DataPermissionSave;
import com.alinesno.infra.common.extend.datasource.annotation.DataPermissionScope;
import com.alinesno.infra.common.facade.datascope.PermissionQuery;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 处理与ProductTypeEntity相关的请求的Controller。
 * 继承自BaseController类并实现IProductTypeService接口。
 *
 * @author LuoXiaoDong
 * @version 1.0.0
 */
@Slf4j
@Api(tags = "ProductType")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/platform/productType")
public class ProductTypeController extends BaseController<ProductTypeEntity, IProductTypeService> {

    @Autowired
    private IProductTypeService service;

    /**
     * 获取ProductTypeEntity的DataTables数据。
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

    /**
     * 获取所有产品类型
     * @return
     */
    @DataPermissionQuery
    @GetMapping("/allProductType")
    public AjaxResult allProductType(PermissionQuery query){

        LambdaQueryWrapper<ProductTypeEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>() ;
        lambdaQueryWrapper.setEntityClass(ProductTypeEntity.class);
        query.toWrapper(lambdaQueryWrapper);

        List<ProductTypeEntity> types = service.list(lambdaQueryWrapper);

        return AjaxResult.success(types);
    }

    @DataPermissionSave
    @Override
    public AjaxResult save(Model model, @RequestBody ProductTypeEntity entity) throws Exception {
        return super.save(model, entity);
    }

    @Override
    public IProductTypeService getFeign() {
        return this.service;
    }
}
