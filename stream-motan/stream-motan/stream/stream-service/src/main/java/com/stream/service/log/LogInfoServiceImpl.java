package com.stream.service.log;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.stream.mapper.log.LogInfoMapper;
import com.stream.service.api.entity.log.LogInfo;
import com.stream.service.api.service.log.LogInfoService;

@Service
public class LogInfoServiceImpl implements LogInfoService {

	private static final Logger logger = LoggerFactory.getLogger(LogInfoServiceImpl.class);
	
	@Autowired
	private LogInfoMapper logInfoMapper;
	
	@Override
	public void saveLogInfo(LogInfo LogInfo) throws Exception {
		// TODO Auto-generated method stub
		logger.info("保存用户信息 开始");
		
		logger.info("请求报文:"+JSON.toJSONString(LogInfo));
		logInfoMapper.saveLogInfo(LogInfo);
		
		logger.info("保存用户信息 结束");
		
	}

	@Override
	public List<LogInfo> selectAll() throws Exception {
		// TODO Auto-generated method stub
		logger.info("查询所有用户信息  开始");
		
		List<LogInfo> result = logInfoMapper.selectAll();
		logger.info("响应报文:"+JSON.toJSONString(result));
		
		logger.info("查询所有用户信息  结束");
		
		return result;
	}
	
	
	
}
