package com.stream.mapper.stream;

import java.util.List;

import com.stream.service.api.entity.stream.UserInfo;

public interface UserInfoMapper {

	void saveUserInfo(UserInfo userInfo) throws Exception;

	List<UserInfo> selectAll() throws Exception;

}
