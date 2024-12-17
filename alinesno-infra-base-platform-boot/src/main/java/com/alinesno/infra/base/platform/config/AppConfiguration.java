package com.alinesno.infra.base.platform.config;

import com.alinesno.infra.base.platform.initialize.IPlatformInitService;
import com.alinesno.infra.common.extend.datasource.enable.EnableInfraDataScope;
import com.alinesno.infra.common.facade.enable.EnableActable;
import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import com.alinesno.infra.common.web.log.aspect.LogAspect;
import com.dtflys.forest.springboot.annotation.ForestScan;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableInfraDataScope
@EnableActable
@EnableInfraSsoApi
@EnableAsync
@MapperScan("com.alinesno.infra.base.platform.mapper")
@ForestScan({
        "com.alinesno.infra.common.web.adapter.base.consumer" ,
        "com.alinesno.infra.base.platform.adapter"
})
@EnableScheduling
@Configuration
public class AppConfiguration implements CommandLineRunner {

//    @Autowired
//    private IPlatformInitService platformInitService ;

    @Bean
    public LogAspect getLogAspect(){
        return new LogAspect() ;
    }

    @Override
    public void run(String... args) throws Exception {
//        platformInitService.initProductType();   // 初始化产品类型
//        platformInitService.initProduct();  // 初始化产品
//
//        platformInitService.initPlanType(); // 初始化方案类型
//        platformInitService.initPlan(); // 初始化方案
//
//        platformInitService.initChannel(); // 初始化频道
//
//        platformInitService.initContent(); // 初始化内容
    }
}
