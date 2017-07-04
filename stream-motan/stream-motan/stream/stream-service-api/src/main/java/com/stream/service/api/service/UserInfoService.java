package com.stream.service.api.service;

import java.util.List;

import com.stream.service.api.entity.UserInfo;

public interface UserInfoService {

	void saveUserInfo(UserInfo userInfo) throws Exception;

	List<UserInfo> selectAll() throws Exception;
}
