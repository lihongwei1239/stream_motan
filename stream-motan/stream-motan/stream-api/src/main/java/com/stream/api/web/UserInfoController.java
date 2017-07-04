package com.stream.api.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stream.service.api.entity.UserInfo;
import com.stream.service.api.service.UserInfoService;

@Controller
@RequestMapping("api/userInfo")
public class UserInfoController {

	private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping(value = "/selectAll", method = RequestMethod.POST)
	@ResponseBody
	public List<UserInfo> selectAll() throws Exception {
		logger.info("查询所有用户信息");
		return userInfoService.selectAll();
	}

}
