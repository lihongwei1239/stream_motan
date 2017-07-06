package com.stream.service;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.stream.mapper.stream.UserInfoMapper;
import com.stream.service.api.entity.stream.UserInfo;
import com.stream.service.stream.UserInfoServiceImpl;

public class UserInfoServiceImplTest extends AbstractConfigTest{
	
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
