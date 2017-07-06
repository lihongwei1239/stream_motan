package com.stream.service.stream;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.stream.mapper.stream.UserInfoMapper;
import com.stream.service.api.entity.stream.UserInfo;
import com.stream.service.api.service.stream.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Override
	public void saveUserInfo(UserInfo userInfo) throws Exception {
		// TODO Auto-generated method stub
		logger.info("保存用户信息 开始");
		
		logger.info("请求报文:"+JSON.toJSONString(userInfo));
		userInfoMapper.saveUserInfo(userInfo);
		
		logger.info("保存用户信息 结束");
		
	}

	@Override
	public List<UserInfo> selectAll() throws Exception {
		// TODO Auto-generated method stub
		logger.info("查询所有用户信息  开始");
		
		List<UserInfo> result = userInfoMapper.selectAll();
		logger.info("响应报文:"+JSON.toJSONString(result));
		
		logger.info("查询所有用户信息  结束");
		
		return result;
	}
	
	
	
}
