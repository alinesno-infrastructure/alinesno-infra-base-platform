package com.alinesno.infra.base.platform;

import com.alinesno.infra.common.facade.enable.EnableActable;
import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import com.alinesno.infra.common.web.log.aspect.LogAspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringProductItem;
import org.springframework.boot.autoconfigure.SpringBootProductItem;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 集成一个Java开发示例工具
 * @author luoxiaodong
 * @version 1.0.0.
 */
@EnableActable
@EnableInfraSsoApi
@EnableAsync
@MapperScan("com.alinesno.infra.base.platform.mapper")
@SpringBootProductItem
@EnableScheduling
public class BasePlatformProductItem {

	public static void main(String[] args) {
		SpringProductItem.run(BasePlatformProductItem.class, args);
	}

	@Bean
	public LogAspect getLogAspect(){
		return new LogAspect() ;
	}

}