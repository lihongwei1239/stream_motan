package com.stream.mapper;

import java.util.List;

import com.stream.service.api.entity.UserInfo;

public interface UserInfoMapper {

	void saveUserInfo(UserInfo userInfo) throws Exception;

	List<UserInfo> selectAll() throws Exception;

}
