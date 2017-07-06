package com.stream.service.api.service.log;

import java.util.List;

import com.stream.service.api.entity.log.LogInfo;

public interface LogInfoService {

	void saveLogInfo(LogInfo logInfo) throws Exception;

	List<LogInfo> selectAll() throws Exception;
}
