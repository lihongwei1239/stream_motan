package com.stream.context;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 建立动态数据源 
 * @author lihongwei1239
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return DataSourceContextHolder.getDataSourceType();
	}

}
