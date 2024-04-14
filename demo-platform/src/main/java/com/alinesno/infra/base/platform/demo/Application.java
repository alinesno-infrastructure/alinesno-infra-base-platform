package com.alinesno.infra.base.init.demo;

import org.springframework.boot.SpringProductItem;
import org.springframework.boot.autoconfigure.SpringBootProductItem;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootProductItem(exclude = DataSourceAutoConfiguration.class)
public class ProductItem {

	public static void main(String[] args) {
		SpringProductItem.run(ProductItem.class, args);
	}

}