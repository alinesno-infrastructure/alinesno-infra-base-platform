package com.alinesno.infra.base.platform.service.impl;

import com.alinesno.infra.base.platform.api.dto.ProductItemDto;
import com.alinesno.infra.base.platform.api.dto.ProductTypeDto;
import com.alinesno.infra.base.platform.entity.ProductItemEntity;
import com.alinesno.infra.base.platform.entity.ProductTypeEntity;
import com.alinesno.infra.base.platform.enums.OwnerEnums;
import com.alinesno.infra.base.platform.mapper.ProductItemMapper;
import com.alinesno.infra.base.platform.mapper.ProductTypeMapper;
import com.alinesno.infra.base.platform.service.IProductTypeService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductTypeServiceImpl extends IBaseServiceImpl<ProductTypeEntity, ProductTypeMapper> implements IProductTypeService {

    @Autowired
    private ProductItemMapper productItemMapper ;

    @Override
    public List<ProductTypeDto> findByOrgId(String orgId) {
        log.info("findByOrgId:{}", orgId);

        // 根据orgId查询产品类型信息，并转换为ProductTypeDto列表返回
        LambdaQueryWrapper<ProductTypeEntity> queryWrapper = new LambdaQueryWrapper<>();

        if(StringUtils.isNotEmpty(orgId)){
            queryWrapper.eq(ProductTypeEntity::getOrgId, orgId);
        }else {
            queryWrapper.eq(ProductTypeEntity::getTypeOwner, OwnerEnums.PLATFORM.getCode());
        }

        List<ProductTypeEntity> productTypeEntities = this.list(queryWrapper);

        if (productTypeEntities != null && !productTypeEntities.isEmpty()) {
            return productTypeEntities.stream().map(entity -> {

                ProductTypeDto dto = new ProductTypeDto();
                BeanUtils.copyProperties(entity, dto) ;

                LambdaQueryWrapper<ProductItemEntity> itemQueryWrapper = new LambdaQueryWrapper<>();
                itemQueryWrapper.eq(ProductItemEntity::getProductTypeId, entity.getId())  ;

                List<ProductItemEntity> productItemEs= productItemMapper.selectList(itemQueryWrapper);
                log.info("productItemEs:{}", productItemEs);

                if(productItemEs != null && !productItemEs.isEmpty()){
                    List<ProductItemDto> productItemDtos = productItemEs.stream().map(item -> {
                        ProductItemDto itemDto = new ProductItemDto();
                        BeanUtils.copyProperties(item, itemDto) ;

                        return itemDto;
                    }).toList() ;

                    dto.setProductItem(productItemDtos);
                }

                return dto;
            }).toList();
        }

        return null;
    }

    @Override
    public void saveOrgProductCategory(ProductTypeDto productTypeDto) {

        log.info("saveOrgProductCategory:{}", productTypeDto);

        long count = this.count(new LambdaQueryWrapper<ProductTypeEntity>().eq(ProductTypeEntity::getCode, productTypeDto.getCode()));
        if(count > 0){
            throw new RuntimeException("该标识已存在产品分类，请勿重复添加！") ;
        }

        ProductTypeEntity entity = new ProductTypeEntity();
        BeanUtils.copyProperties(productTypeDto, entity) ;

        this.save(entity);
    }

}
