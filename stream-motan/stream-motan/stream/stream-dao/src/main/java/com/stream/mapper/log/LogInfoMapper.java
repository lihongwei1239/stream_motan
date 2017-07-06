package com.stream.mapper.log;

import java.util.List;

import com.stream.service.api.entity.log.LogInfo;

public interface LogInfoMapper {

	void saveLogInfo(LogInfo LogInfo) throws Exception;

	List<LogInfo> selectAll() throws Exception;

}
