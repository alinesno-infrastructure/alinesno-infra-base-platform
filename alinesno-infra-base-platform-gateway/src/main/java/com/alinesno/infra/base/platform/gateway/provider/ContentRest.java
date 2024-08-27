package com.alinesno.infra.base.platform.gateway.provider;

import com.alinesno.infra.base.platform.api.dto.ContentDto;
import com.alinesno.infra.base.platform.service.IContentService;
import com.alinesno.infra.common.facade.response.R;
import com.alinesno.infra.common.web.adapter.rest.SuperController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 内容控制器
 */
@Slf4j
@RestController
@RequestMapping("/api/infra/base/platform/provider/content")
public class ContentRest extends SuperController {

    @Autowired
    private IContentService contentService;

    /**
     * 根据类型标识查询内容列表
     */
    @GetMapping("/getContentListByType")
    public R<List<ContentDto>> getContentListByType(String type) {
        return R.ok(contentService.getContentListByType(type));
    }


    /**
     * 更新内容查看次数
     */
    @GetMapping("/updateViewCount")
    public R<Integer> updateViewCount(long id) {
        contentService.updateViewCount(id);
        return R.ok() ;
    }


    /**
     * 获取内容详情
     */
    @GetMapping("/getContentDetail")
    public R<ContentDto> getContentDetail(long id) {
        return R.ok(contentService.getContentDetail(id));
    }


}
