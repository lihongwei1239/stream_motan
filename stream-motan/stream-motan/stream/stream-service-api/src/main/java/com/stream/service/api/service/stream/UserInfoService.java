package com.stream.service.api.service.stream;

import java.util.List;

import com.stream.service.api.entity.stream.UserInfo;

public interface UserInfoService {

	void saveUserInfo(UserInfo userInfo) throws Exception;

	List<UserInfo> selectAll() throws Exception;
}
