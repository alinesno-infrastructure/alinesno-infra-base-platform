package com.alinesno.infra.base.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 集成一个Java开发示例工具
 * @author luoxiaodong
 * @version 1.0.0.
 */
@EnableAsync
@SpringBootApplication
@EnableScheduling
public class OpsLogbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpsLogbackApplication.class, args);
	}

}