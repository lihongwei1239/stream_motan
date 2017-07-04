package com.stream.service;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.stream.mapper.UserInfoMapper;
import com.stream.service.api.entity.UserInfo;

public class DemoServiceImplTest extends AbstractConfigTest{
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private UserInfoServiceImpl userInfoServiceImpl;
	
	@Test
	public void saveUserInfo() throws Exception {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(UUID.randomUUID().toString());
		userInfoServiceImpl.saveUserInfo(userInfo);
	}
	
	
	@Test
	public void selectAll() throws Exception {
		List<UserInfo> result = userInfoMapper.selectAll();
		System.out.println(JSON.toJSON(result));
	}
}
