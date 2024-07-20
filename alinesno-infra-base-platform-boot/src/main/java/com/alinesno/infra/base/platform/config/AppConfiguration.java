package com.alinesno.infra.base.platform.config;

import com.alinesno.infra.common.facade.enable.EnableActable;
import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import com.alinesno.infra.common.web.log.aspect.LogAspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableActable
@EnableInfraSsoApi
@EnableAsync
@MapperScan("com.alinesno.infra.base.platform.mapper")
@EnableScheduling
@Configuration
public class AppConfiguration {

    @Bean
    public LogAspect getLogAspect(){
        return new LogAspect() ;
    }

}
