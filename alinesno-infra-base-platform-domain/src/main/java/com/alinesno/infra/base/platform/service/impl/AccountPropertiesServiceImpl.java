package com.alinesno.infra.base.platform.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.base.platform.api.MenuItemDto;
import com.alinesno.infra.base.platform.entity.AccountPropertiesEntity;
import com.alinesno.infra.base.platform.enums.AccountPropertiesEnums;
import com.alinesno.infra.base.platform.mapper.AccountPropertiesMapper;
import com.alinesno.infra.base.platform.service.IAccountPropertiesService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AccountPropertiesServiceImpl extends IBaseServiceImpl<AccountPropertiesEntity, AccountPropertiesMapper> implements IAccountPropertiesService {

    @Override
    public List<MenuItemDto> queryConstomView(long orgId) {
        LambdaQueryWrapper<AccountPropertiesEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AccountPropertiesEntity::getOrgId, orgId)
                .eq(AccountPropertiesEntity::getPKey, AccountPropertiesEnums.ORGANIZATION_VIEW.getCode()) ;

        AccountPropertiesEntity entity = this.getOne(queryWrapper) ;
        if(entity != null){
            return JSONObject.parseArray(entity.getPValue(), MenuItemDto.class) ;
        }
        return null ;
    }

    @Override
    public void saveCustomView(List<MenuItemDto> menuItemDtoList, long orgId) {

        log.info("保存自定义视图：{}", JSONObject.toJSONString(menuItemDtoList)) ;

        LambdaQueryWrapper<AccountPropertiesEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AccountPropertiesEntity::getOrgId, orgId)
                .eq(AccountPropertiesEntity::getPKey, AccountPropertiesEnums.ORGANIZATION_VIEW.getCode()) ;

        AccountPropertiesEntity entity = this.getOne(queryWrapper) ;

        if(entity == null){
            entity = new AccountPropertiesEntity() ;
        }

        entity.setOrgId(orgId) ;
        entity.setPKey(AccountPropertiesEnums.ORGANIZATION_VIEW.getCode()) ;
        entity.setPValue(JSONObject.toJSONString(menuItemDtoList)) ;

        this.saveOrUpdate(entity) ;
    }
}
