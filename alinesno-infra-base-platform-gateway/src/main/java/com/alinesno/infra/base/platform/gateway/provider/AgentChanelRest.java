package com.alinesno.infra.base.platform.gateway.provider;

import com.alinesno.infra.base.platform.api.AgentRoleDto;
import com.alinesno.infra.base.platform.entity.AgentChannelEntity;
import com.alinesno.infra.base.platform.entity.AgentRoleEntity;
import com.alinesno.infra.base.platform.enums.ChannelType;
import com.alinesno.infra.base.platform.service.IAgentChannelService;
import com.alinesno.infra.base.platform.service.IAgentRoleService;
import com.alinesno.infra.common.facade.response.R;
import com.alinesno.infra.common.web.adapter.rest.SuperController;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 内容控制器
 */
@Slf4j
@RestController
@RequestMapping("/api/infra/base/platform/provider/agentChannel")
public class AgentChanelRest extends SuperController {

    @Autowired
    private IAgentChannelService agentChannelService;

    @Autowired
    private IAgentRoleService agentRoleService ;

    @GetMapping("/getAgentRole")
    public R<List<AgentRoleDto>> getAgentRole() {

        LambdaQueryWrapper<AgentRoleEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(AgentRoleEntity::getOrderNumber) ;
        List<AgentRoleEntity> list = agentRoleService.list(queryWrapper) ;

        List<AgentRoleDto> dtos = list.stream().map(item -> new AgentRoleDto(item.getId(),
                item.getRoleAvatar(),
                item.getRoleName(),
                item.getResponsibilities(),
                item.getRoleLevel(),
                item.getRoleLink(),
                item.getOrderNumber())).toList();

        return R.ok(dtos) ;
    }

    // 查询出所有的hastStatus状态为正常的频道
    @GetMapping("/findAll")
    public R<AgentChannelResponse> findAll() {

        // 获取所有状态正常的频道
        List<AgentChannelEntity> allChannels = agentChannelService.findAllByHasStatus() ;

        // 按照频道类型分类
        Map<String, List<AgentChannelEntity>> channelsByType = allChannels.stream()
                .collect(Collectors.groupingBy(AgentChannelEntity::getType));

        // 创建响应对象
        List<AgentChannelEntity> recommendChannels = channelsByType.getOrDefault(ChannelType.RECOMMEND_CHANNEL.getValue(), new ArrayList<>());
        List<AgentChannelEntity> specificChannels = channelsByType.getOrDefault(ChannelType.PUBLIC_CHANNEL.getValue(), new ArrayList<>());

        AgentChannelResponse response = new AgentChannelResponse(recommendChannels, specificChannels);

        return R.ok(response) ;
    }

    @Data
    public static class AgentChannelResponse {

        @JsonProperty("recommend")
        private List<AgentChannelEntity> recommendChannels;

        @JsonProperty("public")
        private List<AgentChannelEntity> specificChannels;

        public AgentChannelResponse(List<AgentChannelEntity> recommendChannels, List<AgentChannelEntity> specificChannels) {
            this.recommendChannels = recommendChannels;
            this.specificChannels = specificChannels;
        }
    }

}
