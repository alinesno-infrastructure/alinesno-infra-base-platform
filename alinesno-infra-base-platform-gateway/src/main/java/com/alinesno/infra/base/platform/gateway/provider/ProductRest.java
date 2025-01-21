package com.alinesno.infra.base.platform.gateway.provider;

import com.alinesno.infra.base.platform.api.dto.ProductItemDto;
import com.alinesno.infra.base.platform.api.dto.ProductTypeDto;
import com.alinesno.infra.base.platform.service.IProductItemService;
import com.alinesno.infra.base.platform.service.IProductTypeService;
import com.alinesno.infra.common.facade.response.R;
import com.alinesno.infra.common.web.adapter.rest.SuperController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 产品管理控制器
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/api/infra/base/platform/provider/product")
public class ProductRest extends SuperController {

    @Autowired
    private IProductItemService productItemService;

    @Autowired
    private IProductTypeService productTypeService;

    /**
     * 获取到推荐的应用列表
     */
    @GetMapping("/recommendedProducts")
    public R<List<ProductItemDto>> recommendedProducts() {
        // 获取推荐的应用列表，并转换为ProductItemDto列表返回
        return R.ok(productItemService.recommendedProducts());
    }

    /**
     * 删除组织业务产品delOrgProduct
     */
    @DeleteMapping("/delOrgProduct")
    public R<String> delOrgProduct(@RequestParam Long productId) {

        // 删除组织业务产品，并返回删除结果
        productItemService.removeById(productId);

        return R.ok("删除成功");
    }

    /**
     * 删除组织产品分类delProductCategory
     */
    @DeleteMapping("/delProductCategory")
    public R<String>  delProductCategory(@RequestParam Long categoryId) {
        // 判断分类下面是否包含产品
        if (!productItemService.findByCategoryId(categoryId).isEmpty()) {
            return R.fail("该分类下存在产品，无法删除");
        }

        productTypeService.removeById(categoryId);

        return R.ok("删除成功");
    }

    /**
     * 保存组织业务产品
     */
    @PostMapping("/saveOrgProduct")
    public R<String> saveOrgProduct(@RequestBody ProductItemDto productItemDto) {

        // 获取组织产品信息，并保存到数据库
        productItemService.saveOrgProduct(productItemDto);

        return R.ok("保存成功");
    }

    /**
     * 保存组织产品分类
     */
    @PostMapping("/saveOrgProductCategory")
    public R<String> saveOrgProductCategory(@RequestBody ProductTypeDto productTypeDto) {

        // 获取组织产品分类信息，并保存到数据库
        productTypeService.saveOrgProductCategory(productTypeDto);

        return R.ok("保存成功");
    }

    /**
     * 查询组织产品分类
     */
    @GetMapping("/queryOrgProductCategory")
    public R<List<ProductTypeDto>> queryOrgProductCategory(@RequestParam String orgId) {
        return R.ok(productTypeService.findByOrgId(orgId));
    }

    /**
     * 通过分类标识查询产品列表
     */
    @GetMapping("/queryProductByTypeCode")
    public R<List<ProductItemDto>> queryProductByTypeCode(@RequestParam String typeCode) {

        // 通过分类标识查询产品列表，并转换为ProductItemDto列表返回
        return R.ok(productItemService.queryProductByTypeCode(typeCode));
    }


}
