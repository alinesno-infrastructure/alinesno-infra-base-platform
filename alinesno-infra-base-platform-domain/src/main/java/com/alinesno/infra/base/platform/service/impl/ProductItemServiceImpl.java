package com.alinesno.infra.base.platform.service.impl;

import com.alinesno.infra.base.platform.api.dto.ProductItemDto;
import com.alinesno.infra.base.platform.entity.ProductItemEntity;
import com.alinesno.infra.base.platform.entity.ProductTypeEntity;
import com.alinesno.infra.base.platform.mapper.ProductItemMapper;
import com.alinesno.infra.base.platform.mapper.ProductTypeMapper;
import com.alinesno.infra.base.platform.service.IProductItemService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductItemServiceImpl extends IBaseServiceImpl<ProductItemEntity, ProductItemMapper> implements IProductItemService {

    @Autowired
    private ProductTypeMapper productTypeMapper ;

    @Override
    public void saveOrgProduct(ProductItemDto productItemDto) {

        ProductItemEntity entity = new ProductItemEntity();
        BeanUtils.copyProperties(productItemDto, entity);

        this.save(entity);
    }

    @Override
    public List<ProductItemDto> queryProductByTypeCode(String typeCode) {

        Long typeId = productTypeMapper.selectOne(new LambdaQueryWrapper<ProductTypeEntity>().eq(ProductTypeEntity::getCode, typeCode)).getId() ;

        LambdaQueryWrapper<ProductItemEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProductItemEntity::getProductTypeId, typeId);
        queryWrapper.orderBy(true, true, ProductItemEntity::getSortNumber) ;

        List<ProductItemEntity> productItemList = this.list(queryWrapper);

        if(productItemList != null && !productItemList.isEmpty()){
            return productItemList.stream().map(item -> {

                ProductItemDto dto = new ProductItemDto();
                BeanUtils.copyProperties(item, dto);

                return dto;
            }).toList();
        }

        return null;
    }
}
