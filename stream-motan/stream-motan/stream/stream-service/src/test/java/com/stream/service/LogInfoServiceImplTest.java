package com.stream.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.stream.constant.DataSourceConstant;
import com.stream.context.DataSourceContextHolder;
import com.stream.mapper.log.LogInfoMapper;
import com.stream.service.api.entity.log.LogInfo;
import com.stream.service.log.LogInfoServiceImpl;

public class LogInfoServiceImplTest extends AbstractConfigTest{
	
	@Autowired
	private LogInfoMapper LogInfoMapper;
	
	@Autowired
	private LogInfoServiceImpl LogInfoServiceImpl;
	
	@Test
	public void saveLogInfo() throws Exception {
		DataSourceContextHolder.setDataSourceType(DataSourceConstant.LOGDATASOURCE);  
		LogInfo LogInfo = new LogInfo();
		LogInfo.setLogIp("192.168.1.200");
		LogInfoServiceImpl.saveLogInfo(LogInfo);
	}
	
	
	@Test
	public void selectAll() throws Exception {
		List<LogInfo> result = LogInfoMapper.selectAll();
		System.out.println(JSON.toJSON(result));
	}
}
