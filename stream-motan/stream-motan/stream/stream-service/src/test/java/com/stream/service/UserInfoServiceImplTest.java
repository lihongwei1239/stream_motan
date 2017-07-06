package com.stream.service;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
		
		for (int i = 0; i < 100; i++) {
			UserInfo userInfo = new UserInfo();
			userInfo.setUserName(UUID.randomUUID().toString());
			userInfoServiceImpl.saveUserInfo(userInfo);
		}
		
	}
	
	
	@Test
	public void selectAll() throws Exception {
		PageHelper.startPage(1, 10);
		List<UserInfo> result = userInfoMapper.selectAll();
		PageInfo<UserInfo> pageInfo = new PageInfo<>(result);
		System.out.println(JSON.toJSON(pageInfo));
	}
}
